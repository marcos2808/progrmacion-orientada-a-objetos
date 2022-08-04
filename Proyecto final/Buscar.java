import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Buscar implements ActionListener
{
	JFrame frame;
	JTextField buscador, nuevaNota;
	JButton botonBuscar, botonEliminar, botonEditar;
	JPanel panel;
	JLabel nombre, cedula, nota;
	
	public Buscar()
	{
		// personalizando buscador
		buscador = new JTextField();
		buscador.setBounds(75, 25, 125, 50);
		
		botonBuscar = new JButton("BUSCAR");
		botonBuscar.setBounds(200, 25, 100, 50);
		botonBuscar.addActionListener(this);
		
		// en el siguiente panel se desplegara la informacion del estudiante
		panel = new JPanel();
		panel.setBackground(Color.black);
		panel.setBounds(75, 100, 225, 125);
		panel.setLayout(new GridLayout(3,1));
		
		// campos de informacion del estudiante
		nombre = new JLabel();
		nombre.setHorizontalAlignment(JLabel.CENTER);
		nombre.setForeground(Color.WHITE);
		panel.add(nombre);
		
		cedula = new JLabel();
		cedula.setHorizontalAlignment(JLabel.CENTER);
		cedula.setForeground(Color.WHITE);
		panel.add(cedula);
		
		nota = new JLabel();
		nota.setHorizontalAlignment(JLabel.CENTER);
		nota.setForeground(Color.WHITE);
		panel.add(nota);
		
		// debajo de la informacion del estudiante se ubicara el boton
		// para eliminar y para editar la nota
		botonEliminar = new JButton("ELIMINAR ESTUDIANTE");
		botonEliminar.setBounds(75, 235, 225, 50);
		botonEliminar.addActionListener(this);
		
		botonEditar = new JButton("EDITAR NOTA");
		botonEditar.setBounds(75, 290, 175, 50);
		botonEditar.addActionListener(this);
		
		nuevaNota = new JTextField();
		nuevaNota.setBounds(250, 290, 50, 50);
		// configurando ventana
		frame = new JFrame("Listado de notas");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,400);
		frame.setResizable(true);
		frame.setLayout(null);
		frame.add(buscador);
		frame.add(botonBuscar);
		frame.add(panel);
		frame.add(botonEliminar);
		frame.add(botonEditar);
		frame.add(nuevaNota);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// extraccion de informacion en el buscador
		String dato = buscador.getText();
		
		// buscar estudiante 
		if (e.getSource() == botonBuscar)
		{
			// coneccion a base de datos
			try 
			{
				Connection driver = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc", "postgres", "tulli1467");
				Statement consulta = driver.createStatement();
				ResultSet resultSet = consulta.executeQuery("SELECT * FROM notas");
				
				while (resultSet.next())
				{
					if (resultSet.getString("cedula").equals(dato))
					{
						// agregando informacion correspondiente a los labels que 
						// contendra el panel
						nombre.setText("Nombre -> " + resultSet.getString("nombre"));
						cedula.setText("Cedula -> " + resultSet.getString("cedula"));
						nota.setText ("Nota -> " + resultSet.getString("nota"));	
					}
				}
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			} 
		}
		
		// eliminar estudiante
		if (e.getSource() == botonEliminar)
		{
			// coneccion a base de datos
			try 
			{
				Connection driver = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc", "postgres", "tulli1467");
				Statement actualizacion = driver.createStatement();
				actualizacion.executeUpdate("DELETE FROM notas WHERE cedula='"+dato+"'");
				frame.dispose();
				new Menu();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		
		// editar nota
		if (e.getSource() == botonEditar)
		{
			// coneccion a base de datos
			try 
			{
				Connection driver = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc", "postgres", "tulli1467");
				Statement actualizacion = driver.createStatement();
				actualizacion.executeUpdate("UPDATE notas SET nota="+nuevaNota.getText()+
											"WHERE cedula='"+dato+"'");
				frame.dispose();
				new Menu();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
	}
}
