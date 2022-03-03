import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JOptionPane;

public class View extends JFrame
{
    private Container pane;
    
    private String playerOnTurn;

    private JButton[] board;

    public View()
    {
        super();

        pane = getContentPane();
        pane.setLayout(new GridLayout(3 , 3));
        
        setTitle("Tic Tac Toe");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        playerOnTurn = "X";

        board = new JButton[9];

        createBoard();
    }

    private void createBoard()
    {
        for(int i = 0; i < board.length; i ++)
        {
            JButton button = new JButton();
            button.setFont(new Font("Arial", Font.PLAIN, 100));
            
            board[i] = button;

            button.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e) 
                {
                    if(((JButton)e.getSource()).getText().equals("") && !checkForWinner()) 
                    {
                        button.setText(playerOnTurn);
                        setPlayerOnTurn();
                    }
                }
            });
            
            pane.add(button);  
        }
    }

    private void setPlayerOnTurn()
    {
    	if(playerOnTurn.equals("X"))
    	{
    		playerOnTurn = "O";
    	}
    	else
    	{
    		playerOnTurn = "X";
    	}
    }

    private boolean checkForWinner()
    {    
        if(board[0].getText().equals(playerOnTurn) && board[1].getText().equals(playerOnTurn) && board[2].getText().equals(playerOnTurn))
        {
            JOptionPane.showMessageDialog(null, "Player " + playerOnTurn + " has won!");
            
            return true;
        }
        else if(board[3].getText().equals(playerOnTurn) && board[4].getText().equals(playerOnTurn) && board[5].getText().equals(playerOnTurn))
        {
            JOptionPane.showMessageDialog(null, "Player " + playerOnTurn + " has won!");
            
            return true;
        }
        else if(board[6].getText().equals(playerOnTurn) && board[7].getText().equals(playerOnTurn) && board[8].getText().equals(playerOnTurn))
        {
            JOptionPane.showMessageDialog(null, "Player " + playerOnTurn + " has won!");
            
            return true;
        }
        else if(board[0].getText().equals(playerOnTurn) && board[3].getText().equals(playerOnTurn) && board[6].getText().equals(playerOnTurn))
        {
            JOptionPane.showMessageDialog(null, "Player " + playerOnTurn + " has won!");
            
            return true;
        }
        else if(board[1].getText().equals(playerOnTurn) && board[4].getText().equals(playerOnTurn) && board[7].getText().equals(playerOnTurn))
        {
            JOptionPane.showMessageDialog(null, "Player " + playerOnTurn + " has won!");
            
            return true;
        }
        else if(board[2].getText().equals(playerOnTurn) && board[5].getText().equals(playerOnTurn) && board[8].getText().equals(playerOnTurn))
        {
            JOptionPane.showMessageDialog(null, "Player " + playerOnTurn + " has won!");
            
            return true;
        }
        else if(board[0].getText().equals(playerOnTurn) && board[4].getText().equals(playerOnTurn) && board[8].getText().equals(playerOnTurn))
        {
            JOptionPane.showMessageDialog(null, "Player " + playerOnTurn + " has won!");
            
            return true;
        }
        if(board[2].getText().equals(playerOnTurn) && board[4].getText().equals(playerOnTurn) && board[6].getText().equals(playerOnTurn))
        {
            JOptionPane.showMessageDialog(null, "Player " + playerOnTurn + " has won!");
            
            return true;
        }

        return false;
    }
}
