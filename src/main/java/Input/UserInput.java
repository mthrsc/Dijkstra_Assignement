package Input;

import javax.swing.JOptionPane;

/**
 *
 * @author Matthieu Roscio
 * UserInput.java
 * 18 11 2020
 */
public class UserInput {

    int input1 = -1;
    int input2 = -1;

    public UserInput() {
    }

    public void promptUser(int vertices) {

        while (input1 < 0 || input1 > vertices) {
            try {
                input1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter a valid source node: "));
                if (input1 < 0) {
                    throw new NumberOutOfRange();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valide INTEGER");
            } catch (NumberOutOfRange ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        while (input2 < 0 || input2 > vertices) {
            try {
                input2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter destination node: "));
                if (input2 < 0) {
                    throw new NumberOutOfRange();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valide INTEGER");
            } catch (NumberOutOfRange ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }

    public int getInput1() {
        return input1;
    }

    public int getInput2() {
        return input2;
    }
}
