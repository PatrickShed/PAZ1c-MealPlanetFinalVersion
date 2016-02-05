package sk.upjs.ics.mealplanet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class AddForm extends javax.swing.JFrame {

    private IngredientDao ingredientDao = IngredientDaoFactory.INSTANCE.getIngredientDao();
    private RecipeDao recipeDao = RecipeDaoFactory.INSTANCE.getRecipeDao();
    private List<Ingredient> ingredients = new ArrayList<>();   //vsetky ingrediencie z databazy 
    private Map<Ingredient, String> addedIngredients = new HashMap<Ingredient, String>();
    private List<String> addedIngredientsNames = new ArrayList<String>();  //na pracu s vybratymi ingredienciami v jListe
    private MealTypeDao mealTypeDao = MealTypeDaoFactory.INSTANCE.getMealTypeDao();

    public AddForm() {
        //nastavi sa cely addform
        initComponents();
        setLocationRelativeTo(null);
        this.setMealTypesCombobox(); //nastavi sa mealtypeCombobox
        this.setIngredientsCombobox(); //nastavi sa ingredientsCombobox
        this.stepsTextArea.setLineWrap(true);
        this.stepsTextArea.setWrapStyleWord(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        recipeNameLabel = new javax.swing.JLabel();
        recipeNameTextField = new javax.swing.JTextField();
        prepTimeLabel = new javax.swing.JLabel();
        minutesLabel = new javax.swing.JLabel();
        mealtypeComboBox = new javax.swing.JComboBox();
        addIngredientButton = new javax.swing.JButton();
        ingredientsLabel = new javax.swing.JLabel();
        ingredientComboBox = new javax.swing.JComboBox();
        amountTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        addedIngredientsList = new javax.swing.JList();
        deleteIngredientButton = new javax.swing.JButton();
        ratingSlider = new javax.swing.JSlider();
        ratingjLabel = new javax.swing.JLabel();
        ratingNumberLabel = new javax.swing.JLabel();
        addRecipeButton = new javax.swing.JButton();
        stepsLabel = new javax.swing.JLabel();
        prepTimeSpinner = new javax.swing.JSpinner();
        addNewIngredientButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        stepsTextArea = new javax.swing.JTextArea();
        headerLabel = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Meal Planet - Add recipe");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recipeNameLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        recipeNameLabel.setText("Recipe name:");
        getContentPane().add(recipeNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 37, -1, -1));
        getContentPane().add(recipeNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 34, 520, -1));

        prepTimeLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        prepTimeLabel.setText("Preparation time: ");
        getContentPane().add(prepTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        minutesLabel.setText("minutes");
        getContentPane().add(minutesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));

        getContentPane().add(mealtypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 62, 161, -1));

        addIngredientButton.setText("Add ingredient");
        addIngredientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addIngredientButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addIngredientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 140, -1));

        ingredientsLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ingredientsLabel.setText("Ingredients:");
        getContentPane().add(ingredientsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        getContentPane().add(ingredientComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 119, 230, 30));

        amountTextField.setText("amount");
        amountTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                amountTextFieldFocusGained(evt);
            }
        });
        getContentPane().add(amountTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 120, -1));

        jScrollPane1.setViewportView(addedIngredientsList);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(123, 213, 227, 110));

        deleteIngredientButton.setText("Delete ingredient");
        deleteIngredientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteIngredientButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteIngredientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 140, -1));
        getContentPane().add(ratingSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 230, -1));

        ratingjLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ratingjLabel.setText("Rating:");
        getContentPane().add(ratingjLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        ratingNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, ratingSlider, org.jdesktop.beansbinding.ELProperty.create("${value}"), ratingNumberLabel, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        getContentPane().add(ratingNumberLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 27, -1));

        addRecipeButton.setText("Add recipe");
        addRecipeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRecipeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addRecipeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, 120, -1));

        stepsLabel.setText("Steps:");
        getContentPane().add(stepsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 213, -1, -1));
        getContentPane().add(prepTimeSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 61, -1));

        addNewIngredientButton.setText("Add new ingredient");
        addNewIngredientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewIngredientButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addNewIngredientButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 140, -1));

        stepsTextArea.setColumns(20);
        stepsTextArea.setRows(5);
        jScrollPane2.setViewportView(stepsTextArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 213, 243, 110));

        headerLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        headerLabel.setText("Add recipe");
        getContentPane().add(headerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 120, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Patrik\\Pictures\\PS\\MealPlanet\\PAZ1cMealplanetBGsimple-OptimalSoftWhite.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 370));

        bindingGroup.bind();

        setBounds(0, 0, 667, 402);
    }// </editor-fold>//GEN-END:initComponents

    private void setIngredientsCombobox() {
        //Tato metoda vyplni combobox s ingredienciami
        ingredientComboBox.removeAllItems(); //vymazu sa stare aby sa combob. aktualizoval
        ingredients = ingredientDao.getAllOrdered(); //ulozome si ingrediencie z databazy do zoznamu
        ingredientComboBox.addItem(""); //"Prvu" ingredienciu nastavime ako bezmennu
        for (Ingredient ingredient : ingredients) {
            ingredientComboBox.addItem(ingredient.getName()); //v cykle pridavame do comboboxu nazvy ingrediencii
        }
        ingredientComboBox.setEditable(true); //mozeme do combob. pisat
        AutoCompleteDecorator.decorate(ingredientComboBox); //combob. nam podla toho co piseme dokoncuje slovo
    }

    private void setMealTypesCombobox() {
        //Metoda ktora vyplni mealtype combobox
        List<String> mealTypeNames = mealTypeDao.getAllNames(); //nacitame si mealtypey z databazy
        for (String mealTypeName : mealTypeNames) {
            mealtypeComboBox.addItem(mealTypeName); //nahadzeme nazvy mealtypeov do combob.
        }
    }

    private void amountTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amountTextFieldFocusGained
        amountTextField.setText(null); //po kliknuti/tabulatore sa vymaze text vo vnutri textFieldu
    }//GEN-LAST:event_amountTextFieldFocusGained

    private void addIngredientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addIngredientButtonActionPerformed
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
                // zo zoznamu vsetkych ingrediencii najde ingredieniu, ktora je vybrana v comboboxe
                addedIngredients.put(ingredient, amountTextField.getText());//prida do mapy ingredienciu a jej mnozstvo
                addedIngredientsNames.add(ingredient.getName() + " - " + amountTextField.getText());// prida meno ingr. a jej mnozstvo do jListu
            }

        }
        addedIngredientsList.setListData(addedIngredientsNames.toArray());

    }//GEN-LAST:event_addIngredientButtonActionPerformed

    private void deleteIngredientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteIngredientButtonActionPerformed
        for (Ingredient ingredient : addedIngredients.keySet()) {//prechadza mapu pridanych ingrediencii
            String ingredAndAmount = ingredient.getName() + " - " + addedIngredients.get(ingredient);// vyrobi string ktory vyzera rovnako ako v jListe
            if (ingredAndAmount.equals(addedIngredientsList.getSelectedValue())) {// ak sa ten STRING stotoznuje s vybranou ingredienciou v jListe
                addedIngredients.remove(ingredient);// odstrani ingredienciu z mapy
                addedIngredientsNames.remove(ingredAndAmount);//odstrani ingredienciu zo zoznamu mien ingrediencii
                addedIngredientsList.setListData(addedIngredientsNames.toArray());//aktualizuje jList
                return;
            }

        }
    }//GEN-LAST:event_deleteIngredientButtonActionPerformed

    private void addRecipeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRecipeButtonActionPerformed
        List<Recipe> lastRecipe = recipeDao.getLast();        // vrati posledny recept v databaze, lebo nemame v databaze autoincrement
        Recipe recipe = new Recipe();// vytvori novy recept, ktory bude neskor pridany do databazy
        //nastavovanie premennych , ktore neskor sa nastavia receptu, ale, najskor musia prejst cez validaciu
        String name = recipeNameTextField.getText();
        int prepTime = (int) prepTimeSpinner.getValue();
        String steps = stepsTextArea.getText();
        int rating = ratingSlider.getValue();
        int type = mealtypeComboBox.getSelectedIndex();
        long newIdr = lastRecipe.get(0).getIdR() + 1;// id noveho receptu, je tam +1, lebo nemame autoincrement
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
        //nastavenie premennych receptu
        recipe.setName(name);
        recipe.setSteps(steps);
        recipe.setRating(rating);
        recipe.setPrepTime(prepTime);
        recipe.setType(type);
        recipe.setIdR(newIdr);
//vlozenie receptu do databazy
        recipeDao.add(recipe);
//pridanie Relations do databazy
        for (Ingredient ingredient : addedIngredients.keySet()) {
            Relation relation = new Relation();
            relation.setAmount(addedIngredients.get(ingredient));
            relation.setIdI(ingredient.getIdI());
            relation.setIdR(newIdr);

            RelationDao relationDao = RelationDaoFactory.INSTANCE.getRelationDao();
            relationDao.addRelation(relation);// pridanie konkretnej relation do databazy
        }
        this.setVisible(false);//zavrie sa okno

    }//GEN-LAST:event_addRecipeButtonActionPerformed

    private void addNewIngredientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewIngredientButtonActionPerformed
        Ingredient newIngredient = new Ingredient();//vytvorenie prazdnej ingrediencie ktora vojde do tohto noveho okna, kde sa jej nastavia premenne
//otvori sa nove okno na pridavanie ingrediencii
        AddIngredientDialog addIngredientDialog = new AddIngredientDialog(this, true, newIngredient);
        addIngredientDialog.setVisible(true);
        addIngredientDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ingredients.add(newIngredient);
        System.out.println(newIngredient.getName());
//pridanu novu ingredienciu zobrazi v comboboxe ingrediencii
        this.setIngredientsCombobox();
    }//GEN-LAST:event_addNewIngredientButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure ?", "Watch out", dialogButton);
        if (dialogResult == 0) {
            this.setVisible(false);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addIngredientButton;
    private javax.swing.JButton addNewIngredientButton;
    private javax.swing.JButton addRecipeButton;
    private javax.swing.JList addedIngredientsList;
    private javax.swing.JTextField amountTextField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteIngredientButton;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JComboBox ingredientComboBox;
    private javax.swing.JLabel ingredientsLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox mealtypeComboBox;
    private javax.swing.JLabel minutesLabel;
    private javax.swing.JLabel prepTimeLabel;
    private javax.swing.JSpinner prepTimeSpinner;
    private javax.swing.JLabel ratingNumberLabel;
    private javax.swing.JSlider ratingSlider;
    private javax.swing.JLabel ratingjLabel;
    private javax.swing.JLabel recipeNameLabel;
    private javax.swing.JTextField recipeNameTextField;
    private javax.swing.JLabel stepsLabel;
    private javax.swing.JTextArea stepsTextArea;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
