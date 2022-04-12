package persistencia.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.PersonaDTO;

public class PersonaDAOSQL implements PersonaDAO {
	private static final String insert = "INSERT INTO personas(idPersona, nombre, telefono, email, nacimiento, domicilio, tipo_contacto, mes_nacimiento, plataforma_almacenamiento) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String readall = "SELECT * FROM personas";
	private static final String update = "UPDATE personas p set nombre = ? , telefono = ? , email = ? , nacimiento = ? , domicilio = ? , tipo_contacto = ?, mes_nacimiento = ?, plataforma_almacenamiento = ? where p.idPersona = ?";

	public boolean insert(PersonaDTO persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());
			statement.setString(4, persona.getEmail());
			statement.setString(5, persona.getNacimiento());
			statement.setInt(6, persona.getDomicilio());
			statement.setInt(7, persona.getIdTipoContacto());
			statement.setString(8, persona.getMesNacimiento());
			statement.setString(9, persona.getPlataformaAlmacenamiento());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isInsertExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return isInsertExitoso;
	}

	public boolean update(PersonaDTO persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getTelefono());
			statement.setString(3, persona.getEmail());
			statement.setString(4, persona.getNacimiento());
			statement.setInt(5, persona.getDomicilio());
			statement.setInt(6, persona.getIdTipoContacto());
			statement.setString(7, persona.getMesNacimiento());
			statement.setString(8, persona.getPlataformaAlmacenamiento());
			statement.setInt(9, persona.getIdPersona());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isUpdateExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return isUpdateExitoso;
	}

	public boolean delete(PersonaDTO persona_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isdeleteExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}

	public List<PersonaDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				personas.add(getPersonaDTO(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personas;
	}

	private PersonaDTO getPersonaDTO(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("idPersona");
		String nombre = resultSet.getString("Nombre");
		String tel = resultSet.getString("Telefono");
		String email = resultSet.getString("Email");
		String nacimiento = resultSet.getString("Nacimiento");
		int idDomicilio = resultSet.getInt("Domicilio");
		int idTipoDeContacto = resultSet.getInt("Tipo_Contacto");
		String mes_nacimiento = resultSet.getString("Mes_Nacimiento");
		String plataforma_almacenamiento = resultSet.getString("Plataforma_Almacenamiento");
		return new PersonaDTO(id, nombre, tel, email, nacimiento, idDomicilio, idTipoDeContacto, mes_nacimiento,
				plataforma_almacenamiento);
	}
}
