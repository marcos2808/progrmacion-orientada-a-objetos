import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu implements ActionListener
{
	JFrame frame;
	JButton botonAgregar, botonBuscar;
	Menu()
	{
		// personalizando botones
		botonAgregar = new JButton("AGREGAR ESTUDIANTE");
		botonAgregar.setBounds(100, 125, 200, 50);
		botonAgregar.addActionListener(this);
		
		botonBuscar = new JButton("BUSCAR ESTUDIANTE");
		botonBuscar.setBounds(100, 200, 200, 50);
		botonBuscar.addActionListener(this);
		
		// configurando ventana
		frame = new JFrame("Listado de notas");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setResizable(true);
		frame.setLayout(null);
		frame.add(botonAgregar);
		frame.add(botonBuscar);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == botonAgregar)
		{
			frame.dispose();
			new Agregar();
		}
		if (e.getSource() == botonBuscar)
		{
			frame.dispose();
			new Buscar();
		}
	}
}
