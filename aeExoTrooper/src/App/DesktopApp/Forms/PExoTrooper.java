package App.DesktopApp.Forms;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ListCellRenderer;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;

import App.DesktopApp.CustomControl.PatButton;
import BusinessLogic.FactoryBL;
import DataAccess.DAOs.aeTipoExoBotDAO;
import DataAccess.DAOs.aeExoTrooperDAO;
import DataAccess.DTOs.aeExoBotArmaViewDTO;
import DataAccess.DTOs.aeTipoExoBotDTO;
import Infrastructure.AppConfig;
import Infrastructure.AppMSG;
import Infrastructure.Tools.CMD;

public class PExoTrooper extends JPanel {
    private final transient FactoryBL<aeTipoExoBotDTO> blTipoExoBot = new FactoryBL<>(aeTipoExoBotDAO.class);
    private final transient aeExoTrooperDAO daoExoTrooper = new aeExoTrooperDAO();

    private final JPanel pnlTop = new JPanel(new BorderLayout());
    private final JPanel pnlFilters = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private final JPanel pnlActions = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    private final JPanel pnlTable = new JPanel(new BorderLayout());

    private final JLabel lblTitle = new JLabel("ExoTrooper");
    private final JLabel lblTipo = new JLabel("TipoExoBot:");
    private final JComboBox<aeTipoExoBotDTO> cmbTipoExoBot = new JComboBox<>();

    private final PatButton btnBuscar = new PatButton("Buscar");
    private final PatButton btnEntrenar = new PatButton("EntrenarArma");
    private final PatButton btnAccion = new PatButton("AcciónArma");

    private JTable tbl = new JTable();
    private List<aeExoBotArmaViewDTO> currentRows = new ArrayList<>();

    // Lista simple de soldados expertos genéricos: Soldado Experto-1, 2, 3, ...
    private final List<String> soldadosExpertos = new ArrayList<>();
    private int idxSoldadoActual = 0;

    public PExoTrooper() {
        initComponents();
        loadCombosAndCaches();
        refreshTable(null);
    }

    private void initComponents() {
        setLayout(new BorderLayout(10, 10));

        pnlFilters.add(lblTipo);
        pnlFilters.add(cmbTipoExoBot);

        pnlActions.add(btnBuscar);
        pnlActions.add(btnEntrenar);
        pnlActions.add(btnAccion);

        pnlTop.add(lblTitle, BorderLayout.WEST);
        pnlTop.add(pnlFilters, BorderLayout.CENTER);
        pnlTop.add(pnlActions, BorderLayout.EAST);

        pnlTable.add(new JScrollPane(tbl), BorderLayout.CENTER);

        add(pnlTop, BorderLayout.NORTH);
        add(pnlTable, BorderLayout.CENTER);

        cmbTipoExoBot.setRenderer(new ListCellRenderer<aeTipoExoBotDTO>() {
            private final JLabel label = new JLabel();

            @Override
            public Component getListCellRendererComponent(javax.swing.JList<? extends aeTipoExoBotDTO> list,
                                                         aeTipoExoBotDTO value,
                                                         int index,
                                                         boolean isSelected,
                                                         boolean cellHasFocus) {
                label.setOpaque(true);
                label.setText(value == null ? "" : value.getNombre());
                if (isSelected) {
                    label.setBackground(list.getSelectionBackground());
                    label.setForeground(list.getSelectionForeground());
                } else {
                    label.setBackground(list.getBackground());
                    label.setForeground(list.getForeground());
                }
                return label;
            }
        });

        btnBuscar.addActionListener(e -> onBuscar());
        btnEntrenar.addActionListener(e -> onEntrenar());
        btnAccion.addActionListener(e -> onAccionArma());
    }

    private void loadCombosAndCaches() {
        try {
            List<aeTipoExoBotDTO> tipos = blTipoExoBot.getAll();
            DefaultComboBoxModel<aeTipoExoBotDTO> model = new DefaultComboBoxModel<>();
            for (aeTipoExoBotDTO t : tipos) {
                model.addElement(t);
            }
            cmbTipoExoBot.setModel(model);

            // Soldados expertos genéricos que pueden entrenar cualquier arma
            soldadosExpertos.add("Soldado Experto-1");
            soldadosExpertos.add("Soldado Experto-2");
            soldadosExpertos.add("Soldado Experto-3");
            soldadosExpertos.add("Soldado Experto-4");
            soldadosExpertos.add("Soldado Experto-5");
        } catch (Exception e) {
            AppMSG.showError("Error cargando catálogos ExoTrooper: " + e.getMessage());
        }
    }

    private void refreshTable(Integer idTipoExoBot) {
        try {
            currentRows = (idTipoExoBot == null)
                ? daoExoTrooper.readGridAll()
                : daoExoTrooper.readGridByTipoExoBot(idTipoExoBot);

            String[] header = {"IdExoBot", "TipoExoBot", "TipoArma", "AcciónArma", "Recurso", "Entreno", "No. Acción"};
            Object[][] data = new Object[currentRows.size()][header.length];

            for (int i = 0; i < currentRows.size(); i++) {
                aeExoBotArmaViewDTO r = currentRows.get(i);
                data[i][0] = r.getIdExoBot();
                data[i][1] = r.getTipoExoBot();
                data[i][2] = r.getTipoArma();
                data[i][3] = r.getAccionArma();
                data[i][4] = r.getRecurso();
                data[i][5] = r.getEntreno();
                data[i][6] = r.getNoAccion();
            }

            tbl = new JTable(data, header);
            tbl.setShowHorizontalLines(true);
            tbl.setRowSelectionAllowed(true);
            tbl.setGridColor(Color.lightGray);
            tbl.setColumnSelectionAllowed(false);
            tbl.setFillsViewportHeight(true);

            pnlTable.removeAll();
            pnlTable.add(new JScrollPane(tbl), BorderLayout.CENTER);
            pnlTable.revalidate();
            pnlTable.repaint();
        } catch (Exception e) {
            AppMSG.showError("Error cargando grilla ExoTrooper: " + e.getMessage());
        }
    }

    private void onBuscar() {
        aeTipoExoBotDTO tipo = (aeTipoExoBotDTO) cmbTipoExoBot.getSelectedItem();
        if (tipo == null || tipo.getIdTipoExoBot() == null) {
            AppMSG.showError("Seleccione un TipoExoBot");
            return;
        }
        refreshTable(tipo.getIdTipoExoBot());
    }

    private void onEntrenar() {
        aeTipoExoBotDTO tipo = (aeTipoExoBotDTO) cmbTipoExoBot.getSelectedItem();
        if (tipo == null || tipo.getIdTipoExoBot() == null) {
            AppMSG.showError("Seleccione un TipoExoBot");
            return;
        }

        try {
            Integer idExoBot = daoExoTrooper.getExoBotIdByTipoExoBot(tipo.getIdTipoExoBot());
            if (idExoBot == null) {
                CMD.traceError("No se encontró ExoBot para " + tipo.getNombre());
                return;
            }

            List<aeExoBotArmaViewDTO> rows = daoExoTrooper.readGridByTipoExoBot(tipo.getIdTipoExoBot());
            boolean okAny = false;

            for (aeExoBotArmaViewDTO r : rows) {
                if (soldadosExpertos.isEmpty()) {
                    CMD.traceError("No hay Soldado Experto disponible para entrenar.");
                    continue;
                }

                String nombreSoldado = soldadosExpertos.get(idxSoldadoActual % soldadosExpertos.size());
                idxSoldadoActual++;

                // Siempre usamos la acción asistir (según tu requerimiento)
                CMD.traceGood(nombreSoldado + " " + r.getTipoArma() + " " + "asistir");
                okAny = true;
            }

            if (okAny) {
                daoExoTrooper.setExoBotEntreno(idExoBot, true);
            }
            refreshTable(tipo.getIdTipoExoBot());
        } catch (Exception e) {
            AppMSG.showError("Error en EntrenarArma: " + e.getMessage());
        }
    }

    private void onAccionArma() {
        int selected = tbl.getSelectedRow();
        if (selected < 0 || selected >= currentRows.size()) {
            AppMSG.showError("Seleccione una fila de arma en la grilla.");
            return;
        }

        aeExoBotArmaViewDTO r = currentRows.get(selected);

        try {
            Integer newNoAccion = daoExoTrooper.incrementExoBotNoAccion(r.getIdExoBot());
            if (newNoAccion == null) {
                CMD.traceError(r.getTipoArma() + " " + r.getAccionArma() + " (no se pudo incrementar NoAccion)");
                return;
            }

            String token = r.getTipoRecursos() + "_" + r.getTipoArma();
            boolean existsInFile = tokenExistsInMunisionFile(token);

            Integer idTipoEnergia = daoExoTrooper.getTipoEnergiaIdByNombre(token);
            boolean updated = daoExoTrooper.updateExoBotArmaAccionById(r.getIdExoBotArma(), newNoAccion, idTipoEnergia, token);

            if (!existsInFile || idTipoEnergia == null || !updated) {
                CMD.traceError(r.getTipoArma() + " " + r.getAccionArma() + " " + token);
            } else {
                CMD.traceGood(r.getTipoArma() + " " + r.getAccionArma() + " " + token);
            }

            refreshTable(r.getIdTipoExoBot());
        } catch (Exception e) {
            AppMSG.showError("Error en AcciónArma: " + e.getMessage());
        }
    }

    private boolean tokenExistsInMunisionFile(String token) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(AppConfig.getEXOMUNISION()));
            for (String line : lines) {
                if (line != null && line.contains(token)) {
                    return true;
                }
            }
        } catch (Exception e) {
            // Si falla leer archivo, se considera no encontrado.
        }
        return false;
    }
}
