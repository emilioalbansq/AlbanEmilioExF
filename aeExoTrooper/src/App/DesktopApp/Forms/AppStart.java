package App.DesktopApp.Forms;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import App.DesktopApp.CustomControl.PatButton;

public class AppStart extends JFrame {
    AppMenu   pnlMenu = new AppMenu();
    JPanel    pnlMain = new PHome();

    public AppStart(String tilteApp) {
        initComponents(tilteApp);
        
        PatButton btnHome        = new PatButton("🏠 Home");
        PatButton btnExoTrooper   = new PatButton("🤖 ExoTrooper");

        btnHome         .addActionListener(e -> setPanel(new PHome()));
        btnExoTrooper   .addActionListener(e -> setPanel(new PExoTrooper()));

        pnlMenu.addMenuItem(btnHome        );
        pnlMenu.addMenuItem(btnExoTrooper   );
    }

    private void setPanel(JPanel formularioPanel) {
        Container container = getContentPane();
        container.remove(pnlMain);
        pnlMain = formularioPanel;
        container.add(pnlMain, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void initComponents(String tilteApp) {
        setTitle(tilteApp);
        setSize(930, 600);
        setResizable(false);
        setLocationRelativeTo(null); // Centrar en la pantalla
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Crear un contenedor para los dos paneles usando BorderLayout
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Agregar los paneles al contenedor
        container.add(pnlMenu, BorderLayout.WEST);
        container.add(pnlMain, BorderLayout.CENTER);
        setVisible(true);
    }
}