import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class View extends JFrame
{
    private Container pane;
    
    private String playerOnTurn;

    private JButton[][] board;

    private boolean winner;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem quit;
    private JMenuItem newGame;

    public View()
    {
        super();

        pane = getContentPane();
        pane.setLayout(new GridLayout(3 , 3));
        
        setTitle("Tic Tac Toe");
        setSize(500, 500);
        setResizable(false);//!
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//EXIT_ON_CLOSE
        setVisible(true);

        playerOnTurn = "X";

        board = new JButton[3][3];

        winner = false;

        createBoard();
       // createMenuBar();
    }

    private void createMenuBar()
    {
        menuBar = new JMenuBar();
        menu = new JMenu("File");

        newGame = new JMenuItem("New Game");

        newGame.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
               reset();
            }
        });

        quit = new JMenuItem("Quit");

        quit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
               System.exit(0);
            }
        });

        menu.add(newGame);
        menu.add(quit);

        menuBar.add(menu);

        setJMenuBar(menuBar);
    }

    private void reset()
    {
        playerOnTurn = "X";

        for(int i = 0; i < 3; i ++)
        {
            for(int j = 0; j < 3; j ++)
            {
                board[i][j].setText("");
                winner = false;
            }
        }
    }

    private void createBoard()
    {
        for(int i = 0; i < 3; i ++)
        {
            for(int j = 0; j < 3; j ++)
            {
                JButton button = new JButton();
                button.setFont(new Font("Arial", Font.PLAIN, 100));
                
                board[i][j] = button;

                button.addActionListener(new ActionListener()
                {
					public void actionPerformed(ActionEvent e) 
					{
						if(((JButton)e.getSource()).getText().equals("") && !winner) 
						{
							button.setText(playerOnTurn);
							winner();
							setPlayerOnTurn();
						}
					}
                });
                
                pane.add(button);
            }
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

    private void winner()
    {
        if(board[0][0].getText().equals(playerOnTurn) && board[1][0].getText().equals(playerOnTurn) && board[2][0].getText().equals(playerOnTurn))
        {
            JOptionPane.showMessageDialog(null, "Player " + playerOnTurn + " has won!");
            winner = true;
        }
        else if(board[0][1].getText().equals(playerOnTurn) && board[1][1].getText().equals(playerOnTurn) && board[2][1].getText().equals(playerOnTurn))
        {
            JOptionPane.showMessageDialog(null, "Player " + playerOnTurn + " has won!");
            winner = true;
        }
        else if(board[0][2].getText().equals(playerOnTurn) && board[1][2].getText().equals(playerOnTurn) && board[2][2].getText().equals(playerOnTurn))
        {
            JOptionPane.showMessageDialog(null, "Player " + playerOnTurn + " has won!");
            winner = true;
        }
    }
}
