import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * PostFixGUI
 */
public class PostFixGUI extends JFrame {

    /**
     * userEntry for PostFixEval
     */
    private final JTextField expressionEntry;

    /**
     * result from user input
     */
    private final JTextField expressionOutput;

    /**
     * sets up GUI for Post Fix Eval
     */
    PostFixGUI(){
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setTitle("Survey GUI");
        frame.setSize(475, 200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        JLabel pfe = new JLabel("Welcome to Post Fix Evaluation Calculator");
        pfe.setBounds(85,20, 300, 30);
        panel.add(pfe);

        JLabel entry = new JLabel("Enter Expression:");
        entry.setBounds(10,65,150,30);
        panel.add(entry);

        expressionEntry = new JTextField();
        expressionEntry.setBounds(150,65,300,30);
        panel.add(expressionEntry);

        JLabel output = new JLabel("Solved Expression: ");
        output.setBounds(10,110,150, 30);
        panel.add(output);

        expressionOutput = new JTextField();
        expressionOutput.setBounds(150,110,300, 30);
        panel.add(expressionOutput);

        UserEntry expression = new UserEntry();
        expressionEntry.addKeyListener(expression);

        frame.setVisible(true);
    }

    /**
     * user entry key listener listens for user to enter string expression and sets the result to output field
     */
    public class UserEntry implements KeyListener{

        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            String i = expressionEntry.getText();
            float result = PostFixEval.getPostFixEval(i);
            expressionOutput.setText(String.valueOf(result));
        }
    }
}
