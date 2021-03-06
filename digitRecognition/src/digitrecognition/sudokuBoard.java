package digitrecognition; 
import javax.swing.*;
/**
 *
 * @author gomit
 */
public class sudokuBoard extends JFrame{

    public sudokuBoard() {
        setResizable(false);
        initComponents();
    }
                   
    private void initComponents() {
        sudoku = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        drawing = new javax.swing.JPanel();
        options = new javax.swing.JPanel();
        drawArea = new drawArea();
        recog = new javax.swing.JButton();
        cleanDraw = new javax.swing.JButton();
        solve = new javax.swing.JButton();
        clean = new javax.swing.JButton();
        image = new recognition();
        
        P1 = new sudokuPanel();
        P2 = new sudokuPanel();
        P3 = new sudokuPanel();
        P4 = new sudokuPanel();
        P5 = new sudokuPanel();
        P6 = new sudokuPanel();
        P7 = new sudokuPanel();
        P8 = new sudokuPanel();
        P9 = new sudokuPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout());

        sudoku.setBorder(javax.swing.BorderFactory.createTitledBorder("Sudoku"));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridLayout(3, 3));

        P1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(P1);

        P2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(P2);

        P3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(P3);

        P4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(P4);

        P5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(P5);

        P6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(P6);

        P7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(P7);

        P8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(P8);

        P9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(P9);

        /*javax.swing.GroupLayout sudokuLayout = new javax.swing.GroupLayout(sudoku);
        sudoku.setLayout(sudokuLayout);
        sudokuLayout.setHorizontalGroup(
            sudokuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sudokuLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 21, Short.MAX_VALUE))
        );
        sudokuLayout.setVerticalGroup(
            sudokuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sudokuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );*/

        //getContentPane().add(sudoku);

        drawing.setBorder(javax.swing.BorderFactory.createTitledBorder("Draw"));
        drawArea.setMaximumSize(new java.awt.Dimension(270, 270));
        drawArea.setMinimumSize(new java.awt.Dimension(270, 270));
        drawArea.setPreferredSize(new java.awt.Dimension(270, 270));

        javax.swing.GroupLayout jPaneldrawLayout = new javax.swing.GroupLayout(drawArea);
        drawArea.setLayout(jPaneldrawLayout);
        jPaneldrawLayout.setHorizontalGroup(
            jPaneldrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPaneldrawLayout.setVerticalGroup(
            jPaneldrawLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        recog.setText("Recognize");
        recog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boolean[][] points;
                points = drawArea.getPoints();
                image.setPoints(points);
                image.setImage();
                //image.printBits();
                int num = image.getNumber();
                drawArea.clear();
                image.clear();
            }
        });

        cleanDraw.setText("Clean");
        cleanDraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawArea.clear();
                
            }
        });

        javax.swing.GroupLayout drawingLayout = new javax.swing.GroupLayout(drawing);
        drawing.setLayout(drawingLayout);
        drawingLayout.setHorizontalGroup(
            drawingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(drawingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(drawingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(drawArea, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addGroup(drawingLayout.createSequentialGroup()
                        .addGroup(drawingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(recog, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                            .addComponent(cleanDraw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 55, Short.MAX_VALUE)))
                .addContainerGap())
        );
        drawingLayout.setVerticalGroup(
            drawingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(drawingLayout.createSequentialGroup()
                .addComponent(drawArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(recog)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cleanDraw)
                .addGap(0, 26, Short.MAX_VALUE))
        );

        getContentPane().add(drawing);

        options.setBorder(javax.swing.BorderFactory.createTitledBorder("Options"));

        solve.setText("Solve");
        solve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solver solver = new solver();
                //solver.main();
            }
        });

        clean.setText("Train");
        clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Train");
            }
        });

        javax.swing.GroupLayout optionsLayout = new javax.swing.GroupLayout(options);
        options.setLayout(optionsLayout);
        optionsLayout.setHorizontalGroup(
            optionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(optionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(solve, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(clean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        optionsLayout.setVerticalGroup(
            optionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(solve)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clean)
                .addContainerGap(308, Short.MAX_VALUE))
        );

        getContentPane().add(options);

        pack();
    }                      
                   
    private sudokuPanel P1;
    private sudokuPanel P2;
    private sudokuPanel P3;
    private sudokuPanel P4;
    private sudokuPanel P5;
    private sudokuPanel P6;
    private sudokuPanel P7;
    private sudokuPanel P8;
    private sudokuPanel P9;
    private javax.swing.JButton clean;
    private javax.swing.JButton cleanDraw;
    private javax.swing.JPanel drawing;
    private javax.swing.JPanel jPanel1;
    private drawArea drawArea;
    private javax.swing.JPanel options;
    private javax.swing.JButton recog;
    private javax.swing.JButton solve;
    private javax.swing.JPanel sudoku;
    private recognition image;
}
