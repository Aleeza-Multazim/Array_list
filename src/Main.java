import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame {
    private ArrayList<String> nameList;
    private DefaultListModel<String> listModel;
    private JList<String> list;

    public Main() {
        nameList = new ArrayList<>();
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);

        // Set up the JFrame
        setTitle("ArrayList CRUD Operation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);


        // Create buttons and text fields
        JTextField nameField = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");

        // Add components to the JFrame
        setLayout(new BorderLayout());
        add(new JScrollPane(list), BorderLayout.CENTER);
        JPanel inputPanel = new JPanel();
        inputPanel.add(nameField);
        inputPanel.add(addButton);
        inputPanel.add(editButton);
        inputPanel.add(deleteButton);
        add(inputPanel, BorderLayout.SOUTH);

        // ActionListeners for buttons
        addButton.addActionListener(new ActionListener() {
            @Override

            //ADD
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                if (!name.isEmpty()) {
                    nameList.add(name);
                    listModel.addElement(name);
                    nameField.setText("");
                }
            }
        });

        //Add colors
        addButton.setBackground(Color.ORANGE);
        editButton.setBackground(Color.PINK);
        deleteButton.setBackground(Color.YELLOW);
        editButton.addActionListener(new ActionListener() {


            @Override

            //Edit

            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex >= 0) {
                    String newName = nameField.getText();
                    if (!newName.isEmpty()) {
                        nameList.set(selectedIndex, newName);
                        listModel.set(selectedIndex, newName);
                        nameField.setText("");
                    }
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override

            //Delete
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = list.getSelectedIndex();
                if (selectedIndex >= 0) {
                    nameList.remove(selectedIndex);
                    listModel.remove(selectedIndex);
                    nameField.setText("");
                }
            }
        });

        list.addListSelectionListener(e -> {
            int selectedIndex = list.getSelectedIndex();
            if (selectedIndex >= 0) {
                nameField.setText(nameList.get(selectedIndex));
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main e = new Main();
            e.setVisible(true);
        });
    }
}

