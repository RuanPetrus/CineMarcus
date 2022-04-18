/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cineMarcus.auxiliar;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class CompressorImagem {
    
    public static byte[] comprimir (byte[] imagem, int largura, int altura) {
        try {
            BufferedImage image = bytesToImage(imagem);
            Image imagemRedimensionada = image.getScaledInstance(largura, altura, Image.SCALE_FAST);
            BufferedImage saida = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
            saida.getGraphics().drawImage(imagemRedimensionada, 0, 0, null);
            return imageToBytes(saida);
        } catch (IOException ex) {
            return new byte[0];
        }
    }
    
  
    public static BufferedImage bytesToImage (byte[] bytes) throws IOException {
        InputStream is = new ByteArrayInputStream(bytes);
        BufferedImage bi = ImageIO.read(is);
        return bi;
    }
    
   
    public static byte[] imageToBytes (BufferedImage image, String format) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, format, baos);
        byte[] bytes = baos.toByteArray();
        return bytes;
    }
    
   
    public static byte[] imageToBytes (BufferedImage image) throws IOException {
        return imageToBytes(image, "png");
    }
}
