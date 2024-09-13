import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Carta {
    private int indice;

    public Carta(Random r) {
        indice = r.nextInt(52) + 1;
    }

    public void mostrar(JPanel panel, int x, int y) {
        String nomebreImagen = "\\Cartas\\CARTA" + String.valueOf(indice) + ".jpg";
        ImageIcon Imagen = new ImageIcon(getClass().getResource(nomebreImagen));
        JLabel lbl = new JLabel(Imagen);
        lbl.setBounds(x - 50, 20, Imagen.getIconWidth(), Imagen.getIconHeight());
        panel.add(lbl);

    }

    public Pinta getPinta() {
        if (indice <= 13) {
            return Pinta.TREBOL;
        } else if (indice <= 26) {
            return Pinta.PICA;
        } else if (indice <= 39) {
            return Pinta.CORAZON;
        } else {
            return Pinta.DIAMANTE;
        }

    }

    public NombreCarta getNombre() {
        int residuo = indice % 13;
        if (residuo == 0) {
            residuo = 13;
        }
        return NombreCarta.values()[residuo - 1];

    }

    public int getIndice() {
        return indice;
    }
}
