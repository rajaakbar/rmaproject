package nsi.common;

import static nsi.ServiceProperties.getProperty;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

import org.apache.commons.io.FilenameUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;

import nsi.BaseClass;
import nsi.Log;
import nsi.PropertyConstants;

public abstract class General_File_Utilities extends BaseClass
{

    public General_File_Utilities()
    {
        super();
    }

    private static final String fileFolder = System.getProperty("user.dir") + "/src/test/resources/files/";

    protected void validatePDFDocumentAndBookmarks(String fileName) throws IOException
    {
        PDDocument document = PDDocument.load(new File(fileFolder + fileName));
        PDDocumentInformation info = document.getDocumentInformation();
        PDDocumentCatalog cat = document.getDocumentCatalog();
        PDDocumentOutline root = cat.getDocumentOutline();
        Log.info("Title\t" + info.getTitle());
        Log.info("Author\t" + info.getAuthor());

        PDOutlineItem item = root.getFirstChild();
        while (item != null)
        {
            Log.info("Item:- " + item.getTitle());
            PDOutlineItem child = item.getFirstChild();
            while (child != null)
            {
                PDPage page = child.findDestinationPage(document);
                int pageNo = document.getDocumentCatalog().getPages().indexOf(page) + 1;
                Log.info("\tBookmark page:-\t" + pageNo + "\tOutline Title:- " + child.getTitle());
                child = child.getNextSibling();
            }
            item = item.getNextSibling();
        }
        document.close();
    }

    protected String saveFileToReportsFolder(String location) throws MalformedURLException, IOException
    {
        URL url = new URL(location);
        InputStream in = url.openStream();
        String fileName = FilenameUtils.getName(location);
        Files.copy(in, Paths.get(fileFolder + fileName), StandardCopyOption.REPLACE_EXISTING);
        Log.info("File saved to " + fileFolder + fileName);
        in.close();
        printFile(fileName);
        return fileName;
    }

    protected void printFile(String fileName) throws FileNotFoundException
    {
        if (getProperty(PropertyConstants.PRINT_FILES).toLowerCase().equals("y"))
        {
            FileInputStream fis = new FileInputStream(fileFolder + fileName);

            Doc doc = new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
            PrintService service = PrintServiceLookup.lookupDefaultPrintService();

            try
            {
                service.createPrintJob().print(doc, null);
            }
            catch (PrintException e)
            {
                e.printStackTrace();
            }
        }
    }
}
