import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * Main frame (window) of the application.
 *
 * @author Tom Verhoeff (TU/e)
<!--//# BEGIN TODO Name, group id, and date-->
<p><font color="red"><b>Lev Osipov, 271(1), 13.12.2013</b></font></p>
<!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFram
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxList = new javax.swing.JCheckBox();
        jCheckBoxCount = new javax.swing.JCheckBox();
        jCheckBoxIntersection = new javax.swing.JCheckBox();
        jCheckBoxElimination = new javax.swing.JCheckBox();
        jButtonGenerate = new javax.swing.JButton();
        jTextFieldSum = new javax.swing.JTextField();
        jTextFieldLength = new javax.swing.JTextField();
        jLabelSum = new javax.swing.JLabel();
        jLabelLength = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaResult = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SimpleKakuroHelper");
        setResizable(false);

        jCheckBoxList.setText("List");
        jCheckBoxList.setNextFocusableComponent(jCheckBoxCount);

        jCheckBoxCount.setSelected(true);
        jCheckBoxCount.setText("Count");

        jCheckBoxIntersection.setText("Intersection");
        jCheckBoxIntersection.setNextFocusableComponent(jCheckBoxElimination);

        jCheckBoxElimination.setText("Elimination");
        jCheckBoxElimination.setNextFocusableComponent(jButtonGenerate);

        jButtonGenerate.setText("Generate");
        jButtonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerateActionPerformed(evt);
            }
        });

        jTextFieldSum.setNextFocusableComponent(jTextFieldLength);

        jTextFieldLength.setNextFocusableComponent(jCheckBoxList);

        jLabelSum.setText("Sum:");
        jLabelSum.setName(""); // NOI18N

        jLabelLength.setText("Length:");

        jTextAreaResult.setEditable(false);
        jTextAreaResult.setColumns(20);
        jTextAreaResult.setRows(5);
        jScrollPane1.setViewportView(jTextAreaResult);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelLength)
                            .addComponent(jLabelSum))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldLength, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(jTextFieldSum)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxCount)
                            .addComponent(jCheckBoxIntersection)
                            .addComponent(jCheckBoxList)
                            .addComponent(jCheckBoxElimination)
                            .addComponent(jButtonGenerate))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldSum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSum))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelLength))
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxList)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxCount)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxIntersection)
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxElimination)
                        .addGap(14, 14, 14)
                        .addComponent(jButtonGenerate))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

//# BEGIN TODO Implementation of jButtonGenerateActionPerformed
    private void jButtonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerateActionPerformed
        // TODO add your handling code here:
        jTextAreaResult.setText("");
        int sum; // digit sum
        int length; // number of digits
        try {
            sum = Integer.parseInt(jTextFieldSum.getText());
            length = Integer.parseInt(jTextFieldLength.getText());
        }
        catch (NumberFormatException e) {
            jTextAreaResult.append("Needs 2 numbers");
            return;
        }
        if (sum < 0) {
            jTextAreaResult.append("0 <= Sum required");
            return;
        }
        if (length < 0) {
            jTextAreaResult.append("0 <= Length <= 9 required");
            return;
        }
        KakuroCombinationGenerator generator = 
                new KakuroCombinationGenerator(); // generator instance
        CompositeGeneratorObserver<Set<Integer>> observer = 
                new CompositeGeneratorObserver<>(); // main observer
        Lister lister = new Lister(); // listener
        Counter counter = new Counter(); // listener
        Intersector intersector = new Intersector(9, false); // listener
        Intersector eliminator = new Intersector(9, true); // listener
        if (jCheckBoxList.isSelected()) { // adding listener 
            PushPullAdapter listerPPA = 
                    new PushPullAdapter(lister, true); 
            observer.add(listerPPA);
        }
        if (jCheckBoxCount.isSelected()) { // adding listener
            PushPullAdapter counterPPA = 
                    new PushPullAdapter(counter, true); 
            observer.add(counterPPA);
        }
        if (jCheckBoxIntersection.isSelected()) { // adding listener
            PushPullAdapter intersectorPPA = 
                    new PushPullAdapter(intersector, true); 
            observer.add(intersectorPPA);
        }
        if (jCheckBoxElimination.isSelected()) { // adding listener
            PushPullAdapter eliminatorPPA = 
                    new PushPullAdapter(eliminator, true); 
            observer.add(eliminatorPPA);
        }
        generator.setObserver(observer);
        generator.generate(sum, length);
        if (jCheckBoxList.isSelected()) {
            for (HashSet<Integer> comb : lister.getCombs()) {
                jTextAreaResult.append(comb.toString() + "\n");
            }
        }
        if (jCheckBoxCount.isSelected()) {
            jTextAreaResult.append("Number of combinations generated: " + 
                    counter.getCount() + "\n");
        }
        if (jCheckBoxIntersection.isSelected()) {
            jTextAreaResult.append("Intersection: " + 
                    intersector.getIntersection().toString() + "\n");
        }
        if (jCheckBoxElimination.isSelected()) {
            jTextAreaResult.append("Elimination: " + 
                    eliminator.getIntersection().toString() + "\n");
        }
    }//GEN-LAST:event_jButtonGenerateActionPerformed
//# END TODO
    
    /** Listener that appends generated combinations to the text area. */
    private class Lister implements GeneratorListener {
//# BEGIN TODO Implementation of Appender
        
        /** All posible combinations */
        private ArrayList<HashSet<Integer>> combs = 
                new ArrayList<HashSet<Integer>>();
        
        public ArrayList<HashSet<Integer>> getCombs() {
            return combs;
        }
        
        @Override
        public void combinationGenerated(Set<Integer> combination) {
            combs.add(new HashSet<Integer>(combination));
        }
//# END TODO
    }
    
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGenerate;
    private javax.swing.JCheckBox jCheckBoxCount;
    private javax.swing.JCheckBox jCheckBoxElimination;
    private javax.swing.JCheckBox jCheckBoxIntersection;
    private javax.swing.JCheckBox jCheckBoxList;
    private javax.swing.JLabel jLabelLength;
    private javax.swing.JLabel jLabelSum;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaResult;
    private javax.swing.JTextField jTextFieldLength;
    private javax.swing.JTextField jTextFieldSum;
    // End of variables declaration//GEN-END:variables
}
