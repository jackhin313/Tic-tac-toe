import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class App implements ActionListener{

    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[][] button = new JButton[3][3];
    Boolean turn = true;

    App(){
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setTitle("tic tac toe");
        frame.setVisible(true);
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Ink Free",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("tic tac toe");
        textfield.setOpaque(true);
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);
        button_panel.setLayout(new GridLayout(3,3));
        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button.length; j++){
                button[i][j] = new JButton();
                button_panel.add(button[i][j]);
                button[i][j].setFont(new Font("MV Boli",Font.BOLD,120));
                button[i][j].setFocusable(false);
                button[i][j].addActionListener(this);
            }
        }
        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
    }
    public static void main(String[] args) throws Exception {
        new App();
    }

    public void check() {
        String result = null;
        for (int i = 0; i < 3; i++) {
            if(button[i][0].getText() == "X" && button[i][1].getText() == "X" && button[i][2].getText() == "X"){
                result = button[i][0].getText();
            }
            if(button[0][i].getText() == "X" && button[1][i].getText() == "X" && button[2][i].getText() == "X"){
                result = button[0][i].getText();
            }
        }
        if(button[0][0].getText() == "X" && button[1][1].getText() == "X" && button[2][2].getText() == "X"){
            result = button[0][0].getText();
        }
        if(button[2][0].getText() == "X" && button[1][1].getText() == "X" && button[0][2].getText() == "X"){
            result = button[2][0].getText();
        }

        for (int i = 0; i < 3; i++) {
            if(button[i][0].getText() == "O" && button[i][1].getText() == "O" && button[i][2].getText() == "O"){
                result = button[i][0].getText();
            }
            if(button[0][i].getText() == "O" && button[1][i].getText() == "O" && button[2][i].getText() == "O"){
                result = button[0][i].getText();
            }
        }
        if(button[0][0].getText() == "O" && button[1][1].getText() == "O" && button[2][2].getText() == "O"){
            result = button[0][0].getText();
        }
        if(button[2][0].getText() == "O" && button[1][1].getText() == "O" && button[0][2].getText() == "O"){
            result = button[2][0].getText();
        }
        int count = 0;
        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button.length; j++) {
                if(button[i][j].getText() == "O" || button[i][j].getText() == "X"){
                    count++;
                }
            }
        }
        if(count == 9 && result == null){
            result = "D";
        }
        if(result != null){
            win(result);
        }
    }

    public void win(String result) {
        if(result == "X"){
            textfield.setText("X win");
        }
        if(result == "O"){
            textfield.setText("O win");
        }
        if(result == "D"){
            textfield.setText("Draw");
        }
        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button.length; j++) {
                button[i][j].setEnabled(false);
            }
        }
        int value = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Thank you for playing", JOptionPane.YES_NO_OPTION);
        if(value == 0){
            reset();
        }
        if(value == 1){
            System.exit(0);
        }
    }

    public void reset() {
        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button.length; j++) {
                button_panel.remove(button[i][j]);
                button[i][j] = new JButton();
                button_panel.add(button[i][j]);
                button[i][j].setFont(new Font("MV Boli",Font.BOLD,120));
                button[i][j].setFocusable(false);
                button[i][j].addActionListener(this);
                textfield.setText("tic tac toe");
                turn = true;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < button.length; i++) {
            for (int j = 0; j < button.length; j++) {
                if(e.getSource() == button[i][j]){
                    if(turn){
                        if(button[i][j].getText()==""){
                            button[i][j].setForeground(new Color(255,0,0));
                            button[i][j].setText("X");
                            turn = false;
                        }
                    }
                    else{
                        if(button[i][j].getText()==""){
                            button[i][j].setForeground(new Color(0,0,255));
                            button[i][j].setText("O");
                            turn = true;
                        }
                    }
                }
                check();
            }
        }
    }
}
