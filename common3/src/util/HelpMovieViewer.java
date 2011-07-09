/*
 * MediaPlayerPanel.java
 *
 * Created on February 28, 2008, 10:08 PM
 */

package util;

import component.AbstractPanel;
import component.MainWindow;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.ControllerEvent;
import javax.media.ControllerListener;
import javax.media.Manager;
import javax.media.Player;
import javax.media.RealizeCompleteEvent;

/**
 *
 * @author  Entokwaa
 */
public class HelpMovieViewer extends javax.swing.JPanel implements ActionListener, ControllerListener {

    private boolean isFullscreen;
    static HelpMovieViewer viewer;
    URL moviePath;
    private Component visualComponent;
    private Player playerVideo;

    public static void showPanelHelp() {
        AbstractPanel pnl = MainWindow.getDisplayedModule();
        showPanelHelp(pnl, pnl.getClass().getSimpleName());
    }

    private static void showPanelHelp(AbstractPanel pnl, String movie) {
        try {
            if (viewer == null) {
                new util.HelpMovieViewer();
            }
            viewer.moviePath = null;
            java.io.InputStream is = util.DataUtil.getResource(BeanUtil.concat("help/movie/",movie,".mov"));
            java.io.File f = new java.io.File(BeanUtil.concat(constants.Constants.ROOT_FOLDER,"tmp/" , movie , ".mov"));
            if (!f.exists()) {
                DataUtil.writeToFile(is, BeanUtil.concat(constants.Constants.ROOT_FOLDER,"tmp/" , movie , ".mov"));
            }
            viewer.moviePath = f.toURL();
            if (viewer.moviePath == null) {
                util.PanelUtil.showError(pnl, "Help not set for this form.");
                return;
            }
            viewer.dlgShowMovie.setTitle(BeanUtil.concat("Help for ",pnl.getTitle()));
            viewer.showDialogMovie();
        } catch (IOException ex) {
            Logger.getLogger("global").log(Level.SEVERE, null, ex);
        }
    }

    private void showDialogMovie() {
        playMovie();
        pnlDialogMovieViewer.removeAll();
        pnlDialogMovieViewer.add(this);
        dlgShowMovie.setVisible(true);
    }

    @SuppressWarnings(value = "deprecation")
    private void playMovie() {
        try {
            if (playerVideo != null) {
                playerVideo.stop();
                playerVideo.close();
            }
            playerVideo = null;
            visualComponent = null;

            playerVideo = Manager.createPlayer(moviePath);

            pnlVideo.removeAll();
            pnlController.removeAll();
            playerVideo.removeControllerListener(this);
            playerVideo.addControllerListener(this);
            playerVideo.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Creates new form MediaPlayerPanel */
    private HelpMovieViewer() {
        initComponents();
        viewer = this;
        pnlDialogMovieViewer.setMinimumSize(new Dimension(800, 600));
        dlgShowMovie.setMinimumSize(new Dimension(800, 600));
        dlgShowMovie.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Log.out("WINDOW");
                if (playerVideo!=null) {
                    playerVideo.stop();
                }
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {

        dlgShowMovie = new javax.swing.JDialog();
        pnlDialogMovieViewer = new javax.swing.JPanel();
        pnlVideo = new javax.swing.JPanel();
        pnlController = new javax.swing.JPanel();

        dlgShowMovie.setTitle("Help Movie Player");
        dlgShowMovie.setAlwaysOnTop(true);
        dlgShowMovie.getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        pnlDialogMovieViewer.setLayout(new java.awt.GridLayout(1, 0));
        dlgShowMovie.getContentPane().add(pnlDialogMovieViewer);

        pnlVideo.setLayout(new java.awt.GridLayout(1, 0));

        pnlController.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlVideo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                    .addComponent(pnlController, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlController, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlVideo, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void actionPerformed(ActionEvent e) {
    }

    public void controllerUpdate(ControllerEvent c) {
        if (playerVideo == null) {
            return;
        }
        if (c.getSource().equals(playerVideo) && c instanceof RealizeCompleteEvent) {
            if ((visualComponent = playerVideo.getVisualComponent()) != null) {

                pnlVideo.add(visualComponent);
                Component comp = playerVideo.getControlPanelComponent();
                pnlController.add(comp);

                pnlVideo.updateUI();
                pnlController.updateUI();
            }
        }
    }

    public static void main(String[] args) {
        try {
            util.HelpMovieViewer pnl = new util.HelpMovieViewer();
            java.io.File f = new java.io.File(BeanUtil.concat(constants.Constants.ROOT_FOLDER,"tmp/AdmissionForm.mov"));
            pnl.moviePath = f.toURL();
            pnl.showDialogMovie();
        } catch (MalformedURLException ex) {
            Logger.getLogger("global").log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog dlgShowMovie;
    private javax.swing.JPanel pnlController;
    private javax.swing.JPanel pnlDialogMovieViewer;
    private javax.swing.JPanel pnlVideo;
    // End of variables declaration//GEN-END:variables
}
