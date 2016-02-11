package com.journaldev.spring;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.journaldev.spring.model.Inventory;
import com.journaldev.spring.model.Sales;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfWriter;

public class PDFReportView extends AbstractPdfView {

    private BaseFont bfBold;
    private BaseFont bf;
    private int pageNumber = 0;

    @Override
    @SuppressWarnings("unchecked")
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        Sales sales = (Sales) model.get("SalesData");
        createPDF(document, writer, sales);
    }

    private void createPDF(Document doc, PdfWriter docWriter, Sales sales) {

        initializeFonts();

        try {

            doc.addAuthor("betterThanZero");
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator("MySampleCode.com");
            doc.addTitle("Invoice");
            doc.setPageSize(PageSize.LETTER);

            doc.open();
            PdfContentByte cb = docWriter.getDirectContent();

            boolean beginPage = true;
            int y = 0;

            List<Inventory> inventoryList = sales.getInventoryList();
            int count = 0;
            for (Inventory inventory : inventoryList) {
                if (beginPage) {
                    beginPage = false;
                    generateLayout(doc, cb);
                    generateHeader(doc, cb, sales);
                    y = 520;
                }
                generateDetail(doc, cb, count, y, inventory);
                y = y - 15;
                if (y < 50) {
                    printPageNumber(cb);
                    doc.newPage();
                    beginPage = true;
                }
                count++;
            }
            printPageNumber(cb);

        } catch (Exception ex)
        {
            ex.printStackTrace();
        } finally
        {
            if (doc != null)
            {
                doc.close();
            }
            if (docWriter != null)
            {
                docWriter.close();
            }
        }
    }

    private void generateLayout(Document doc, PdfContentByte cb) {

        try {

            // cb.setLineWidth(1f);
            //
            // // Invoice Header box layout
            // cb.rectangle(420, 560, 150, 60);
            // cb.moveTo(420, 720);
            // cb.lineTo(570, 720);
            // cb.moveTo(420, 740);
            // cb.lineTo(570, 740);
            // cb.moveTo(480, 700);
            // cb.lineTo(480, 760);
            // cb.stroke();

            // Invoice Header box Text Headings
            createHeadings(cb, 460, 750, "Account No.");
            createHeadings(cb, 460, 730, "Invoice No.");
            createHeadings(cb, 460, 710, "Invoice Date");
            createHeadings(cb, 460, 690, "TERMS");
            createHeadings(cb, 460, 670, "SALES REP");
            createHeadings(cb, 460, 650, "SHIPPED VIA");
            createHeadings(cb, 460, 630, "F.O.B.");
            createHeadings(cb, 460, 610, "PREPAID or COLLECT");
            createHeadings(cb, 460, 590, "California Department Public Health");
            createHeadings(cb, 460, 570, "Cerfified Organic By CCOF");

            // Invoice Detail box layout
            cb.rectangle(20, 50, 550, 500);
            cb.moveTo(20, 530);
            cb.lineTo(570, 530);

            cb.moveTo(60, 50);
            cb.lineTo(60, 530);
            cb.moveTo(350, 50);
            cb.lineTo(350, 530);
            cb.moveTo(430, 50);
            cb.lineTo(430, 530);
            cb.moveTo(500, 50);
            cb.lineTo(500, 530);
            cb.stroke();

            // Invoice Detail box Text Headings
            createHeadings(cb, 25, 533, "S.No");
            createHeadings(cb, 65, 533, "DESCRIPTION");
            createHeadings(cb, 355, 533, "QUANTITY");
            createHeadings(cb, 435, 533, "UNIT PRICE");
            createHeadings(cb, 505, 533, "AMOUNT");

            // add the images
            Image companyLogo = Image.getInstance("images/ancientagro-logo.png");
            companyLogo.setAbsolutePosition(25, 700);
            companyLogo.scalePercent(25);
            doc.add(companyLogo);

        }

        catch (DocumentException dex) {
            dex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void generateHeader(Document doc, PdfContentByte cb, Sales sales) {
        try {
            createHeadings(cb, 400, 750, sales.getCustomerNo());
            createHeadings(cb, 400, 730, sales.getInvoiceNo());
            createHeadings(cb, 400, 710, sales.getSaleDate());
            createHeadings(cb, 400, 690, "TERMS");
            createHeadings(cb, 400, 670, "SALES REP");
            createHeadings(cb, 400, 650, "SHIPPED VIA");
            createHeadings(cb, 400, 630, "F.O.B.");
            createHeadings(cb, 400, 610, "PREPAID or COLLECT");
            createHeadings(cb, 400, 590, "California Department Public Health");
            createHeadings(cb, 400, 570, "Cerfified Organic By CCOF");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void generateDetail(Document doc, PdfContentByte cb, int index, int y, Inventory inventory) {
        DecimalFormat df = new DecimalFormat("0.00");
        try {
            createContent(cb, 48, y, String.valueOf(index + 1), PdfContentByte.ALIGN_RIGHT);
            String description = inventory.getProductName() + "Tracking No:" + inventory.getSerialNo();
            createContent(cb, 62, y, "Product Description - SIZE " + description, PdfContentByte.ALIGN_LEFT);
            createContent(cb, 355, y, "1", PdfContentByte.ALIGN_LEFT);

            double price = Double.valueOf(df.format(Math.random() * 10));
            double extPrice = price * (index + 1);
            createContent(cb, 455, y, df.format(price), PdfContentByte.ALIGN_RIGHT);
            createContent(cb, 525, y, df.format(extPrice), PdfContentByte.ALIGN_RIGHT);

        }

        catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void createHeadings(PdfContentByte cb, float x, float y, String text) {

        cb.beginText();
        cb.setFontAndSize(bfBold, 8);
        cb.setTextMatrix(x, y);
        cb.showText(text.trim());
        cb.endText();

    }

    private void printPageNumber(PdfContentByte cb) {

        cb.beginText();
        cb.setFontAndSize(bfBold, 8);
        cb.showTextAligned(PdfContentByte.ALIGN_RIGHT, "Page No. " + (pageNumber + 1), 570, 25, 0);
        cb.endText();

        pageNumber++;

    }

    private void createContent(PdfContentByte cb, float x, float y, String text, int align) {

        cb.beginText();
        cb.setFontAndSize(bf, 8);
        cb.showTextAligned(align, text.trim(), x, y, 0);
        cb.endText();

    }

    private void initializeFonts() {

        try {
            bfBold = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
            bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
