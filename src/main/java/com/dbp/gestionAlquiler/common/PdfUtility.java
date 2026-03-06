package com.dbp.gestionAlquiler.common;

import org.apache.pdfbox.pdmodel.PDDocument;

import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidad para convertir archivos PDF a imágenes.
 * Proporciona funcionalidades para convertir PDFs en un directorio a varios formatos de imagen,
 * y guardar las imágenes resultantes en un directorio objetivo.
 */
public class PdfUtility {

    /**
     * Convierte todos los archivos PDF en el directorio especificado a imágenes.
     * 
     * @param inputDirectory Ruta al directorio que contiene archivos PDF
     * @param imageFormat El formato de imagen para convertir (ej. "PNG", "JPEG")
     * @return Lista de objetos File que representan los archivos de imagen convertidos
     * @throws IOException Si hay un error procesando los PDFs o imágenes
     */
    public List<File> convertPdfFilesToImages(String inputDirectory, String imageFormat) throws IOException {
        List<File> imageFiles = new ArrayList<>();
        
        Path inputPath = Paths.get(inputDirectory);
        File directory = inputPath.toFile();
        
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IOException("El directorio de entrada no existe o no es un directorio: " + inputDirectory);
        }
        
        // Obtener todos los archivos PDF en el directorio
        File[] pdfFiles = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));
        
        if (pdfFiles != null) {
            for (File pdfFile : pdfFiles) {
                // Convertir cada PDF a imágenes
                List<File> convertedImages = convertPdfToImages(pdfFile, imageFormat);
                imageFiles.addAll(convertedImages);
            }
        }
        
        return imageFiles;
    }
    
    /**
     * Convierte un único archivo PDF a imágenes.
     * 
     * @param pdfFile El archivo PDF a convertir
     * @param imageFormat El formato de imagen para convertir (ej. "PNG", "JPEG")
     * @return Lista de objetos File que representan los archivos de imagen convertidos
     * @throws IOException Si hay un error procesando el PDF
     */
    private List<File> convertPdfToImages(File pdfFile, String imageFormat) throws IOException {
        List<File> imageFiles = new ArrayList<>();
        System.out.println("Convirtiendo PDF: " + pdfFile.getName());
        PDDocument document = null;
        try {
        
            document = PDDocument.load(pdfFile);
            PDFRenderer renderer = new PDFRenderer(document);
            
            // Para cada página del PDF, crear una imagen
            int pageCount = document.getNumberOfPages();
            
            for (int i = 0; i < pageCount; i++) {
                BufferedImage image = renderer.renderImageWithDPI(i, 300); // 300 DPI para buena calidad
                
                // Crear nombre de archivo con número de página
                String fileName = pdfFile.getName().replaceAll("\\.pdf$", "") + "_page_" + (i + 1) + "." + imageFormat.toLowerCase();
                Path imagePath = Paths.get(pdfFile.getParent(), fileName);
                
                // Guardar la imagen
                javax.imageio.ImageIO.write(image, imageFormat, imagePath.toFile());
                imageFiles.add(imagePath.toFile());
            }
        } finally {
            if (document != null) {
                document.close();
            }
        }
        
        return imageFiles;
    }
    
    /**
     * Guarda una lista de archivos de imagen en el directorio especificado.
     * 
     * @param imageFiles Lista de archivos de imagen a guardar
     * @param outputDirectory Ruta al directorio donde deben guardarse las imágenes
     * @throws IOException Si hay un error guardando las imágenes
     */
    public void saveImagesToDirectory(List<File> imageFiles, String outputDirectory) throws IOException {
        Path outputPath = Paths.get(outputDirectory);
        
        // Crear directorio si no existe
        if (!Files.exists(outputPath)) {
            Files.createDirectories(outputPath);
        }
        
        for (File imageFile : imageFiles) {
            Path targetPath = Paths.get(outputDirectory, imageFile.getName());
            Files.copy(imageFile.toPath(), targetPath);
        }
    }
    
    /**
     * Convierte todos los archivos PDF en un directorio a imágenes y los guarda en el mismo directorio.
     * 
     * @param inputDirectory Ruta al directorio que contiene archivos PDF
     * @throws IOException Si hay un error procesando los PDFs o imágenes
     */
    public void convertAndSavePdfFiles(String inputDirectory, String imageFormat) throws IOException {
        List<File> imageFiles = convertPdfFilesToImages(inputDirectory, imageFormat);
        saveImagesToDirectory(imageFiles, inputDirectory);
    }
    public static void main(String[] args) {
        String inputDirectory = "/Users/davidblancoparis/Documents/facturas/relacionFacturas2025"; // Cambia esto a tu ruta
        String imageFormat = "JPEG"; // Cambia esto al formato de imagen deseado (ej. "JPEG")
        
        PdfUtility pdfUtility = new PdfUtility();
        try {
            pdfUtility.convertAndSavePdfFiles(inputDirectory, imageFormat);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}