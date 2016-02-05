package sk.upjs.ics.mealplanet;

import java.util.ArrayList;
import java.util.List;

public class DetailForm extends javax.swing.JFrame {

    private Recipe recipe;
    private RelationDao relationDao = RelationDaoFactory.INSTANCE.getRelationDao();

    
    public DetailForm() {
        //konstruktor nastavi jTextArea tak aby dobre vyzeral
        initComponents();
        setLocationRelativeTo(null);     
        this.stepsTextArea.setLineWrap(true);
        this.stepsTextArea.setWrapStyleWord(true);
        this.stepsTextArea.setEditable(false);
        this.stepsTextArea.setCaretPosition(0);        
    }
    
    public void setRecipe(Recipe recipe) {
        //Tato metoda nastavi do komponentov informacie o recepte, ktory sme si dali zobrazit
        this.recipe = recipe;
        List<Relation> relations = relationDao.getMatching(recipe.getIdR()); //tu vytvorime list vztahov, tie priraduju receptu ingred.
        List<String> addedIngredients = new ArrayList<>();
        List<Ingredient> ingredients = recipe.getIngredients();
        for (Relation relation : relations) {
            for (Ingredient ingredient : ingredients) {
                if (relation.idI == ingredient.getIdI()) {
                    addedIngredients.add(ingredient.getName() + " - " + relation.getAmount());
                }

            }

        }
        //nastavujeme do jednotlivych okienok vlastnosti receptu
        nameLabel.setText(recipe.getName());
        prepTimeLabel.setText("Preparation time: " + recipe.getPrepTime() + " minutes");
        mealTypeLabel.setText("Meal type: " + recipe.getMealtype().getName());
        ratingLabel.setText("Rating: " + recipe.getRating());
        ingredientsList.setListData(addedIngredients.toArray());
        stepsTextArea.setText(recipe.getSteps());        
    }
    
    public void setRecipeFromEditForm(Recipe recipe, List<String> addedIngredientsList) {
        //Tato metoda nastavi do komponentov informacie o recepte, ktory sme uz upravovali v edit forme
        this.recipe = recipe;
        int type = recipe.getType();
        //podla toho o aky typ receptu ide , nastavime label pre mealtype
        if (type == 1) {
            mealTypeLabel.setText("Meal type: " + "appetizer");
        }
        if (type == 2) {
            mealTypeLabel.setText("Meal type: " + "soup");
        }
        if (type == 3) {
            mealTypeLabel.setText("Meal type: " + "main course");
        }
        if (type == 4) {
            mealTypeLabel.setText("Meal type: " + "dessert");
        }
        if (type == 5) {
            mealTypeLabel.setText("Meal type: " + "snack");
        }
        if (type == 6) {
            mealTypeLabel.setText("Meal type: " + "other");

        }
        // nastavime ostatne komponenty
        nameLabel.setText(recipe.getName());
        prepTimeLabel.setText("Preparation time: " + recipe.getPrepTime() + " minutes");
        ratingLabel.setText("Rating: " + recipe.getRating());
        ingredientsList.setListData(addedIngredientsList.toArray());
        stepsTextArea.setText(recipe.getSteps());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        prepTimeLabel = new javax.swing.JLabel();
        mealTypeLabel = new javax.swing.JLabel();
        ratingLabel = new javax.swing.JLabel();
        ingredientsLabel = new javax.swing.JLabel();
        logoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ingredientsList = new javax.swing.JList();
        stepsLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        stepsTextArea = new javax.swing.JTextArea();
        editRecipeButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        bgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Meal Planet - Recipe detail");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameLabel.setText("name");
        getContentPane().add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 365, -1));

        prepTimeLabel.setText("Preparation time:");
        getContentPane().add(prepTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 39, 244, -1));

        mealTypeLabel.setText("Meal type:");
        getContentPane().add(mealTypeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 59, 244, -1));

        ratingLabel.setText("Rating:");
        getContentPane().add(ratingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 79, 244, -1));

        ingredientsLabel.setText("Ingredients:");
        getContentPane().add(ingredientsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 99, -1, -1));

        logoLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Patrik\\Pictures\\PS\\MealPlanet\\PAZ1cMealplanetMiniLogoEyed.png")); // NOI18N
        getContentPane().add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, -1, 70));

        jScrollPane1.setViewportView(ingredientsList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 290, 120));

        stepsLabel.setText("Steps:");
        getContentPane().add(stepsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        stepsTextArea.setColumns(20);
        stepsTextArea.setRows(5);
        jScrollPane3.setViewportView(stepsTextArea);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 230, 290, 128));

        editRecipeButton.setText("Edit recipe");
        editRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRecipeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(editRecipeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 110, -1));

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 116, -1));

        bgroundLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Patrik\\Pictures\\PS\\MealPlanet\\PAZ1cMealplanetBGsolid.jpg")); // NOI18N
        getContentPane().add(bgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 390, 430));

        setBounds(0, 0, 390, 440);
    }// </editor-fold>//GEN-END:initComponents

    private void editRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRecipeButtonActionPerformed
        //otvori sa nove okno pre editovanie receptu
        EditForm editForm = new EditForm();
        editForm.setRecipeToForm(recipe); //tu sa nastavia do editovacieho okna informacie, ktore uz o recepte pozname
        editForm.setVisible(true);
        editForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(false);
    }//GEN-LAST:event_editRecipeButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.setVisible(false); //iba zavrie okno detail
    }//GEN-LAST:event_cancelButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetailForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgroundLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton editRecipeButton;
    private javax.swing.JLabel ingredientsLabel;
    private javax.swing.JList ingredientsList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel mealTypeLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel prepTimeLabel;
    private javax.swing.JLabel ratingLabel;
    private javax.swing.JLabel stepsLabel;
    private javax.swing.JTextArea stepsTextArea;
    // End of variables declaration//GEN-END:variables
}
