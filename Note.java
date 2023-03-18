import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shrief
 */
public class Note extends JFrame implements ActionListener {

    static File f, openfile;
    FileWriter wFile;
    JFileChooser new_File, open_file;
    JMenuBar menu;
    JTextArea txt;
    JMenu fMenu, fontMn, Edit;
    JMenuItem New, OpenMenu, SaveMenu, ExitMenu, SaveAsMenu, cut, copy, paste,
            delete;

    public Note() {
        this.setLocation(200, 200);
        this.setTitle("NotePad");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add Menu Bar
        new_File = new JFileChooser();
        menu = new JMenuBar();
        txt = new JTextArea(null, 200, 200);
        txt.setColumns(20);
        txt.setRows(5);
        fMenu = new JMenu("File");
        Edit = new JMenu("Edit");
        fontMn = new JMenu("Font");
        New = new JMenuItem("new file");
        OpenMenu = new JMenuItem("open");
        SaveMenu = new JMenuItem("Save");
        SaveAsMenu = new JMenuItem("Save as");
        cut = new JMenuItem("cut");
        paste = new JMenuItem("Paste");
        copy = new JMenuItem("Copy");
        ExitMenu = new JMenuItem("Close");

        // add componant
        Edit.add(cut);
        Edit.add(copy);
        Edit.add(paste);
        fMenu.add(New);
        fMenu.add(OpenMenu);
        fMenu.add(SaveMenu);
        fMenu.add(SaveAsMenu);
        fMenu.add(ExitMenu);
        menu.add(fMenu);
        menu.add(Edit);
        menu.add(fontMn);
        this.setLayout(new BorderLayout());
        this.add(menu, BorderLayout.NORTH);
        this.add(txt, BorderLayout.CENTER);

        // Action ---------------------------------
        New.addActionListener(this);
        SaveMenu.addActionListener(this);
        SaveAsMenu.addActionListener(this);
        ExitMenu.addActionListener(this);
        OpenMenu.addActionListener(this);

        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);        

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Note();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == New) {
            if (!txt.getText().equals("")) {
                String[] option = {"Save", "Don't Save", "Cancel"};
                int button = JOptionPane.showOptionDialog(null, "Do You Want To Save It?!", "NotePad", JOptionPane.WARNING_MESSAGE, 0, null, option, option[0]);
                if (button == 0) {
                    int num = new_File.showSaveDialog(null);
                    if (num == JFileChooser.APPROVE_OPTION) {

                        try {
                            f = new_File.getSelectedFile();
                            String h = f.getName();
                            if (h.contains(".css") || h.contains(".js") || h.contains(".php") || h.contains(".java") || h.contains(".html")
                                    || h.contains(".txt")) {
                                wFile = new FileWriter(new_File.getSelectedFile());
                                wFile.write(txt.getText());
                                wFile.close();
                            } else {
                                wFile = new FileWriter(new_File.getSelectedFile() + ".txt");
                                wFile.write(txt.getText());
                                wFile.close();
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    txt.setText(null);
                } else if (button == 1) {
                    txt.setText(null);
                } else if (button == 2) {
                    this.setVisible(true);
                }

            }
        }
        // Save ------------------------------------------------------
        if (e.getSource() == SaveMenu) {
            int num = new_File.showSaveDialog(null);
            f = new_File.getSelectedFile();
            String h = f.getName();
            if (num == JFileChooser.APPROVE_OPTION) {

                try {

                    if (h.contains(".css") || h.contains(".js") || h.contains(".php") || h.contains(".java") || h.contains(".txt")) {
                        wFile = new FileWriter(new_File.getSelectedFile());
                        wFile.write(txt.getText());
                        wFile.close();
                    } else if (h.contains(".html")) {
                        wFile = new FileWriter(new_File.getSelectedFile());
                        wFile.write(txt.getText());
                        Desktop.getDesktop().browse(f.toURI());
                        wFile.close();
                    } else {
                        wFile = new FileWriter(new_File.getSelectedFile() + ".txt");
                        wFile.write(txt.getText());
                        wFile.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.setTitle(h + " - NotePad");
            }
        }
        //Save AS -----------------------------------------------------
        if (e.getSource() == SaveAsMenu) {
            int num = new_File.showSaveDialog(null);
            f = new_File.getSelectedFile();
            String h = f.getName();
            if (num == JFileChooser.APPROVE_OPTION) {

                try {

                    if (h.contains(".css") || h.contains(".js") || h.contains(".php") || h.contains(".java") || h.contains(".html")
                            || h.contains(".txt")) {
                        wFile = new FileWriter(new_File.getSelectedFile());
                        wFile.write(txt.getText());
                        wFile.close();
                    } else {
                        wFile = new FileWriter(new_File.getSelectedFile() + ".txt");
                        wFile.write(txt.getText());
                        wFile.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.setTitle(h + " - NotePad");
            }
        }
        // Exit -------------------------------------------------------------------------
        if (e.getSource() == ExitMenu) {
            if (!txt.getText().equals("")) {
                String[] option = {"Save", "Don't Save", "Cancel"};
                int button = JOptionPane.showOptionDialog(null, "Do You Want To Save It?!", "NotePad", JOptionPane.WARNING_MESSAGE, 0, null, option, option[0]);
                if (button == 0) {
                    int num = new_File.showSaveDialog(null);
                    if (num == JFileChooser.APPROVE_OPTION) {

                        try {
                            f = new_File.getSelectedFile();
                            String h = f.getName();
                            if (h.contains(".css") || h.contains(".js") || h.contains(".php") || h.contains(".java") || h.contains(".html")
                                    || h.contains(".txt")) {
                                wFile = new FileWriter(new_File.getSelectedFile());
                                wFile.write(txt.getText());
                                wFile.close();
                            } else {
                                wFile = new FileWriter(new_File.getSelectedFile() + ".txt");
                                wFile.write(txt.getText());
                                wFile.close();
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    System.exit(0);
                } else if (button == 1) {
                    System.exit(0);
                } else if (button == 2) {
                    this.setVisible(true);
                }

            } else {
                System.exit(0);
            }
        }
        // Open -----------------------------------------------------------
        if(e.getSource() == OpenMenu){
            String line = null ;
            open_file= new JFileChooser();
            int x =open_file.showOpenDialog(null);
            openfile = open_file.getSelectedFile();
            String h = openfile.getName();
            
                try {
                    this.setTitle(h + " - NotePad");
                    FileReader fr = new FileReader(openfile);
                    BufferedReader bf = new BufferedReader(fr);
                    while((line = bf.readLine())!=null){
                        txt.append(line);
                    }
               
                } catch (IOException ex) {
                    Logger.getLogger(Note.class.getName()).log(Level.SEVERE, null, ex);
                }    
        }
    
        // copy
        if (e.getSource() == copy) {
            txt.setEditable(true);
            txt.copy();
        }
        // paste
        if (e.getSource() == paste) {
            txt.setEditable(true);
            txt.getSelectedText();
            txt.paste();
        }
        // cut
        if (e.getSource() == cut) {
            txt.setEditable(true);
            txt.cut();
        }


    }
}
