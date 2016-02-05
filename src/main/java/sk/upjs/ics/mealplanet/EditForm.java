package sk.upjs.ics.mealplanet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class EditForm extends javax.swing.JFrame {

    private RecipeDao recipeDao = RecipeDaoFactory.INSTANCE.getRecipeDao();
    private List<Ingredient> ingredients = new ArrayList<>();//vsetky ingrediencie z databazy 
    private Map<Ingredient, String> addedIngredients = new HashMap<Ingredient, String>();
    private List<String> addedIngredientsNames = new ArrayList<String>();//na pracu s vybratymi ingredienciami v jListe
    private MealTypeDao mealTypeDao = MealTypeDaoFactory.INSTANCE.getMealTypeDao();
    ///////////////////////////////////toto je ine ako v addForm
    private Recipe recipe;// inicializuje sa zvonku, ked sa vola toto okno
    private RelationDao relationDao = RelationDaoFactory.INSTANCE.getRelationDao();
    private IngredientDao ingredientDao = IngredientDaoFactory.INSTANCE.getIngredientDao();
    //////////////////////////////////

    public EditForm() {
        initComponents();
        setLocationRelativeTo(null);
        this.setIngredientsCombobox();
        this.setMealTypesCombobox();
        this.stepsTextArea.setLineWrap(true);
        this.stepsTextArea.setWrapStyleWord(true);
    }

    private void setIngredientsCombobox() {//to iste ako v AddForm
        ingredientComboBox.removeAllItems();
        ingredients = ingredientDao.getAllOrdered();
        ingredientComboBox.addItem("");
        for (Ingredient ingredient : ingredients) {
            ingredientComboBox.addItem(ingredient.getName());
        }
        ingredientComboBox.setEditable(true);
        AutoCompleteDecorator.decorate(ingredientComboBox);
    }

    private void setMealTypesCombobox() {//to iste ako v AddForm
        List<String> mealTypeNames = mealTypeDao.getAllNames();
        for (String mealTypeName : mealTypeNames) {
            mealtypeComboBox.addItem(mealTypeName);
        }
    }

    public void setRecipeToForm(Recipe recipe) {//nastavenie receptu tomuto oknu
        this.recipe = recipe;
        List<Relation> relations = relationDao.getMatching(recipe.getIdR());//do zoznamu relations da vsetky relations pripadajuce tomuto receptu
        List<Ingredient> ingredients = recipe.getIngredients();// zoznamu ingredientcii priradi vsetky ingredienci, ktore su v recepte
        for (Relation relation : relations) {// tento dvojity for cyklus vyplni mapu Ingrediencia-Amount
            for (Ingredient ingredient : ingredients) {
                if (relation.idI == ingredient.getIdI()) {//ak naslo dvojicu ingrediencia relation
                    addedIngredients.put(ingredient, relation.getAmount());// pridaju sa obidve do mapy
                    addedIngredientsNames.add(ingredient.getName() + " - " + relation.getAmount());//pridaju sa do zoznamu Stringov, ktore budu poto vypisane v jListe
                }

            }

        }
        addedIngredientsList.setListData(addedIngredientsNames.toArray());// jList sa vyplni ingredienciami a mnozstvom
        //vyplnenie dalsich policok 
        recipeNameTextField.setText(recipe.getName());
        mealtypeComboBox.setSelectedIndex(recipe.getType());
        prepTimeSpinner.setValue(recipe.getPrepTime());
        stepsTextArea.setText(recipe.getSteps());
        ratingSlider.setValue(recipe.getRating());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        prepTimeSpinner = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        addedIngredientsList = new javax.swing.JList();
        addNewIngredientButton = new javax.swing.JButton();
        ingredientComboBox = new javax.swing.JComboBox();
        amountTextField = new javax.swing.JTextField();
        addIngredientButton = new javax.swing.JButton();
        saveRecipeButton = new javax.swing.JButton();
        ingredientsLabel = new javax.swing.JLabel();
        minutesLabel = new javax.swing.JLabel();
        stepsLabel = new javax.swing.JLabel();
        mealtypeComboBox = new javax.swing.JComboBox();
        deleteIngredientButton = new javax.swing.JButton();
        ratingSlider = new javax.swing.JSlider();
        prepTimeLabel = new javax.swing.JLabel();
        recipeNameTextField = new javax.swing.JTextField();
        recipeNameLabel = new javax.swing.JLabel();
        ratingLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        ratingNumberLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        stepsTextArea = new javax.swing.JTextArea();
        addedIngredientsLabel = new javax.swing.JLabel();
        headerLabel = new javax.swing.JLabel();
        bgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Meal Planet - Edit recipe");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(prepTimeSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 59, -1));

        jScrollPane1.setViewportView(addedIngredientsList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 220, 110));

        addNewIngredientButton.setText("Add new ingredient");
        addNewIngredientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewIngredientButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addNewIngredientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 140, -1));

        getContentPane().add(ingredientComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 224, -1));

        amountTextField.setText("amount");
        amountTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                amountTextFieldFocusGained(evt);
            }
        });
        getContentPane().add(amountTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 123, -1));

        addIngredientButton.setText("Add ingredient");
        addIngredientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIngredientButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addIngredientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 140, -1));

        saveRecipeButton.setText("Save");
        saveRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveRecipeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(saveRecipeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(403, 340, 110, -1));

        ingredientsLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ingredientsLabel.setText("Ingredients:");
        getContentPane().add(ingredientsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 70, -1));

        minutesLabel.setText("minutes");
        getContentPane().add(minutesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, -1));

        stepsLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        stepsLabel.setText("Steps:");
        getContentPane().add(stepsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, -1, -1));

        getContentPane().add(mealtypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 161, -1));

        deleteIngredientButton.setText("Delete ingredient");
        deleteIngredientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteIngredientButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteIngredientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 140, -1));
        getContentPane().add(ratingSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 220, -1));

        prepTimeLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        prepTimeLabel.setText("Preparation time: ");
        getContentPane().add(prepTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, -1));
        getContentPane().add(recipeNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 500, -1));

        recipeNameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        recipeNameLabel.setText("Recipe name:");
        getContentPane().add(recipeNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 80, -1));

        ratingLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ratingLabel.setText("Rating:");
        getContentPane().add(ratingLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 50, -1));

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 110, -1));

        ratingNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, ratingSlider, org.jdesktop.beansbinding.ELProperty.create("${value}"), ratingNumberLabel, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        getContentPane().add(ratingNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 32, -1));

        stepsTextArea.setColumns(20);
        stepsTextArea.setRows(5);
        jScrollPane2.setViewportView(stepsTextArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 230, 110));

        addedIngredientsLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addedIngredientsLabel.setText("Added ingredients:");
        getContentPane().add(addedIngredientsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 110, -1));

        headerLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        headerLabel.setText("Edit recipe");
        getContentPane().add(headerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 80, 14));

        bgroundLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Patrik\\Pictures\\PS\\MealPlanet\\PAZ1cMealplanetBGsimple-OptimalSoftWhite.jpg")); // NOI18N
        getContentPane().add(bgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 370));

        bindingGroup.bind();

        setBounds(0, 0, 665, 401);
    }// </editor-fold>//GEN-END:initComponents

    private void addNewIngredientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewIngredientButtonActionPerformed
        Ingredient newIngredient = new Ingredient();//vid AddForm
        AddIngredientDialog addIngredientDialog = new AddIngredientDialog(this, true, newIngredient);
        addIngredientDialog.setVisible(true);
        addIngredientDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ingredients.add(newIngredient);
        this.setIngredientsCombobox();
    }//GEN-LAST:event_addNewIngredientButtonActionPerformed

    private void amountTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amountTextFieldFocusGained
        amountTextField.setText(null);//vid AddForm
    }//GEN-LAST:event_amountTextFieldFocusGained

    private void addIngredientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIngredientButtonActionPerformed
        //vid AddForm        
        //Validacie
        if (ingredientComboBox.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "No ingredient selected.");
            return;
        }
        if ("amount".equals(amountTextField.getText()) || "".equals(amountTextField.getText())) {
            JOptionPane.showMessageDialog(this, "Enter amount.");
            return;
        }
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals(ingredientComboBox.getSelectedItem())) {
                addedIngredients.put(ingredient, amountTextField.getText());
                Relation relation = new Relation();
                relation.setIdI(ingredient.getIdI());
                relation.setAmount(amountTextField.getText());
                addedIngredientsNames.add(ingredient.getName() + " - " + amountTextField.getText());
            }

        }
        addedIngredientsList.setListData(addedIngredientsNames.toArray());
    }//GEN-LAST:event_addIngredientButtonActionPerformed

    private void saveRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveRecipeButtonActionPerformed
        relationDao.delete(recipe.getIdR()); //vymaze vsetky predosle relations aby nahradil novymi

        Recipe alteredRecipe = new Recipe();//novy recept ktory nahradi stary, ale nezmeni sa mu id
        //nastavia sa premenne pred validaciou
        String name = recipeNameTextField.getText();
        int prepTime = (int) prepTimeSpinner.getValue();
        String steps = stepsTextArea.getText();
        int rating = ratingSlider.getValue();
        int type = mealtypeComboBox.getSelectedIndex();
        //validacie
        if (name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Recipe name requested");
            return;
        }
        List<Recipe> nameTest = recipeDao.getMatchingName(name);// tu da recepty s rovnakym menom ako to niekto zada
        if(!nameTest.isEmpty()){
            //ak sa v tom zozname nic nenachadza tak OK, ak v nom nieco je tak treba zmenit meno
            JOptionPane.showMessageDialog(this, "Recipe with the same name is already in use, please choose another name.");
            return;
        }
        if (type == 0) {
            JOptionPane.showMessageDialog(this, "Meal type requested");
            return;
        }
        if (prepTime == 0) {
            JOptionPane.showMessageDialog(this, "Preparation time should be more than 0 minutes");
            return;
        }
        if (addedIngredients.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pick at least one ingredient.");
            return;
        }
        if (steps.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Describe your recipe");
            return;
        }
        //ak premenne presli validaciami, tak sa nastavia alteredRecipe
        alteredRecipe.setName(name);
        alteredRecipe.setSteps(steps);
        alteredRecipe.setRating(rating);
        alteredRecipe.setPrepTime(prepTime);
        alteredRecipe.setType(type);
        alteredRecipe.setIdR(recipe.getIdR());  //// lebo ostava predosle idR

        recipeDao.update(alteredRecipe);/// update receptu
        //nastavenie relations
        for (Ingredient ingredient : addedIngredients.keySet()) {
            Relation relation = new Relation();
            relation.setAmount(addedIngredients.get(ingredient));//addedIngredients.get(ingredient)
            relation.setIdI(ingredient.getIdI());
            relation.setIdR(recipe.getIdR());

            relationDao.addRelation(relation);
        }

        JOptionPane.showMessageDialog(this, "You have successfully edited this recipe!");
        this.setVisible(false);
        //znova sa otvori okno DetailForm ale uz so zmennenym receptom
        DetailForm alteredDetailForm = new DetailForm();
        alteredDetailForm.setRecipeFromEditForm(alteredRecipe, addedIngredientsNames);
        alteredDetailForm.setVisible(true);
        alteredDetailForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);


    }//GEN-LAST:event_saveRecipeButtonActionPerformed

    private void deleteIngredientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteIngredientButtonActionPerformed
        //vid AddForm
        for (Ingredient ingredient : addedIngredients.keySet()) {
            String ingredAndAmount = ingredient.getName() + " - " + addedIngredients.get(ingredient);
            if (ingredAndAmount.equals(addedIngredientsList.getSelectedValue())) {
                addedIngredients.remove(ingredient);
                addedIngredientsNames.remove(ingredAndAmount);
                addedIngredientsList.setListData(addedIngredientsNames.toArray());
                return;
            }

        }
    }//GEN-LAST:event_deleteIngredientButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure ?", "Watch out", dialogButton);
        if (dialogResult == 0) {
            DetailForm detailForm = new DetailForm();//ak chceme zatvorit okno , tak sa otvori Detail receptu s nezmenenymi parametrami
            detailForm.setRecipeFromEditForm(recipe, addedIngredientsNames);
            detailForm.setVisible(true);
            detailForm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.setVisible(false);
        }


    }//GEN-LAST:event_cancelButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addIngredientButton;
    private javax.swing.JButton addNewIngredientButton;
    private javax.swing.JLabel addedIngredientsLabel;
    private javax.swing.JList addedIngredientsList;
    private javax.swing.JTextField amountTextField;
    private javax.swing.JLabel bgroundLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteIngredientButton;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JComboBox ingredientComboBox;
    private javax.swing.JLabel ingredientsLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox mealtypeComboBox;
    private javax.swing.JLabel minutesLabel;
    private javax.swing.JLabel prepTimeLabel;
    private javax.swing.JSpinner prepTimeSpinner;
    private javax.swing.JLabel ratingLabel;
    private javax.swing.JLabel ratingNumberLabel;
    private javax.swing.JSlider ratingSlider;
    private javax.swing.JLabel recipeNameLabel;
    private javax.swing.JTextField recipeNameTextField;
    private javax.swing.JButton saveRecipeButton;
    private javax.swing.JLabel stepsLabel;
    private javax.swing.JTextArea stepsTextArea;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
