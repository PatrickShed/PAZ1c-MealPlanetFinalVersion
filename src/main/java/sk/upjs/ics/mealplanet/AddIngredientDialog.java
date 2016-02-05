/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.mealplanet;

import javax.swing.JOptionPane;

public class AddIngredientDialog extends javax.swing.JDialog {

    private Ingredient ingredient;
    private IngredientDao ingredientDao = IngredientDaoFactory.INSTANCE.getIngredientDao();

    public AddIngredientDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);//vygenerovany konstruktor
        initComponents();
    }

    public AddIngredientDialog(java.awt.Frame parent, boolean modal, Ingredient newIngredient) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        ingredient = newIngredient;//zatial prazdna ingrediencia sa nastavi ako instancna
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fatSpinner = new javax.swing.JSpinner();
        carbSpinner = new javax.swing.JSpinner();
        nameLabel = new javax.swing.JLabel();
        carbLabel = new javax.swing.JLabel();
        addIngredientButton = new javax.swing.JButton();
        proteinLabel = new javax.swing.JLabel();
        fatLabel = new javax.swing.JLabel();
        proteinSpinner = new javax.swing.JSpinner();
        infoLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        logoLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Meal Planet - Add new ingredient");
        setBackground(new java.awt.Color(255, 204, 102));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(fatSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 57, -1));
        getContentPane().add(carbSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 57, -1));

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameLabel.setText("Name :");
        getContentPane().add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        carbLabel.setText("Carbohydrates :");
        getContentPane().add(carbLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        addIngredientButton.setText("Add New Ingredient");
        addIngredientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIngredientButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addIngredientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 240, -1));

        proteinLabel.setText("Protein :");
        getContentPane().add(proteinLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        fatLabel.setText("Fat :");
        getContentPane().add(fatLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));
        getContentPane().add(proteinSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 57, -1));

        infoLabel.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        infoLabel.setText("<html>Note: Please fill all fields. In nutrition fields, use format \"grams per 100 grams\"  .</html>");
        infoLabel.setToolTipText("");
        infoLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(infoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 245, 73));
        getContentPane().add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(63, 11, 180, -1));

        logoLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Patrik\\Pictures\\PS\\MealPlanet\\PAZ1cMealplanetMiniLogoEyed.png")); // NOI18N
        getContentPane().add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Patrik\\Pictures\\PS\\MealPlanet\\PAZ1cMealplanetBGsolid.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 260));

        setBounds(0, 0, 265, 288);
    }// </editor-fold>//GEN-END:initComponents

    private void addIngredientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIngredientButtonActionPerformed
        //nastavenie premennych pre ingredienciu
        String name = nameTextField.getText();
        int protein = (int) proteinSpinner.getValue();
        int fat = (int) fatSpinner.getValue();
        int carb = (int) carbSpinner.getValue();
//validacia mena
        if (name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "You have to fill name field.");
        }
//ak presli premenne validacou, tak sa nastavia ingrediencii
        ingredient.setName(name);
        ingredient.setProtein(protein);
        ingredient.setFat(fat);
        ingredient.setCarb(carb);
//prida sa nova ingrediencia do databazy
        ingredientDao.addIngredient(ingredient);

        JOptionPane.showMessageDialog(this, "You have successfully added a new ingredient!");

        this.setVisible(false);

    }//GEN-LAST:event_addIngredientButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddIngredientDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddIngredientDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddIngredientDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddIngredientDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddIngredientDialog dialog = new AddIngredientDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addIngredientButton;
    private javax.swing.JLabel carbLabel;
    private javax.swing.JSpinner carbSpinner;
    private javax.swing.JLabel fatLabel;
    private javax.swing.JSpinner fatSpinner;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JLabel proteinLabel;
    private javax.swing.JSpinner proteinSpinner;
    // End of variables declaration//GEN-END:variables
}
