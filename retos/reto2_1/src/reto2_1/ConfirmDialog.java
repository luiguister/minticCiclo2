package reto2_1;

import javax.swing.JOptionPane;

public class ConfirmDialog {

    public static void main(String[] args) {

        String[] options = {"abc", "def", "ghi", "jkl"};
        //Integer[] options = {1, 3, 5, 7, 9, 11};
        //Double[] options = {3.141, 1.618};
        //Character[] options = {'a', 'b', 'c', 'd'};
        int x = JOptionPane.showOptionDialog(null, "Returns the position of your choice on the array",
                "Click a button",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        System.out.println(x);

    }
}
