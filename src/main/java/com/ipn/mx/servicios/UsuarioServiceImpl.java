package com.ipn.mx.servicios;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.mx.modelo.entidades.Moto;
import com.ipn.mx.modelo.entidades.Usuario;
import com.ipn.mx.modelo.repositorios.UsuarioRepository;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository dao;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return (List<Usuario>)dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return dao.save(usuario);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		dao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Moto> findAllMoto(long idUsuario) {
		return new ArrayList<Moto>(dao.findById(idUsuario).orElse(null).getMotos());
	}

	@Override
	@Transactional(readOnly = true)
	public ByteArrayInputStream reporteMoto(List<Moto> motos) {
		Document documento = new Document();
		ByteArrayOutputStream respuesta = new ByteArrayOutputStream();
		try {
			PdfWriter.getInstance(documento, respuesta);
			documento.open();
			Font tipoLetra = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLUE);
			Paragraph parrafo = new Paragraph("Lista de Motos de Usuario", tipoLetra);
			parrafo.setAlignment(Element.ALIGN_CENTER);
			documento.add(parrafo);
			documento.add(Chunk.NEWLINE);
			Font textFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,9);
			
			PdfPTable tabla = new PdfPTable(5);
			Stream.of("id","Marca","Modelo", "Placas", "Usuario").forEach(headerTitle ->{
				PdfPCell header = new PdfPCell();
				Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,9);
				header.setBackgroundColor(BaseColor.LIGHT_GRAY);
				header.setHorizontalAlignment(Element.ALIGN_CENTER);
				header.setBorderWidth(1);
				header.setPhrase(new Phrase(headerTitle, headerFont));
				tabla.addCell(header);
			});
			for(Moto m: motos) {
				
				PdfPCell celdaNombre = new PdfPCell(new Phrase(Long.toString(m.getIdMoto()), textFont));
				celdaNombre.setPadding(1);
				celdaNombre.setVerticalAlignment(Element.ALIGN_MIDDLE);
				celdaNombre.setHorizontalAlignment(Element.ALIGN_LEFT);
				tabla.addCell(celdaNombre);
				
				PdfPCell celdaPaterno = new PdfPCell(new Phrase(m.getMarcaMoto(), textFont));
				celdaPaterno.setPadding(1);
				celdaPaterno.setVerticalAlignment(Element.ALIGN_MIDDLE);
				celdaPaterno.setHorizontalAlignment(Element.ALIGN_LEFT);
				tabla.addCell(celdaPaterno);
				
				PdfPCell celdaMaterno = new PdfPCell(new Phrase(m.getModeloMoto(), textFont));
				celdaMaterno.setPadding(1);
				celdaMaterno.setVerticalAlignment(Element.ALIGN_MIDDLE);
				celdaMaterno.setHorizontalAlignment(Element.ALIGN_LEFT);
				tabla.addCell(celdaMaterno);
				
				PdfPCell celdaEmail = new PdfPCell(new Phrase(m.getPlacasMoto(), textFont));
				celdaEmail.setPadding(1);
				celdaEmail.setVerticalAlignment(Element.ALIGN_MIDDLE);
				celdaEmail.setHorizontalAlignment(Element.ALIGN_LEFT);
				tabla.addCell(celdaEmail);
				
				PdfPCell celdaUser = new PdfPCell(new Phrase(m.getIdUsuario().getNombreUsuario()+" " + m.getIdUsuario().getPaternoUsuario() + " " + m.getIdUsuario().getMaternoUsuario(), textFont));
				celdaUser.setPadding(1);
				celdaUser.setVerticalAlignment(Element.ALIGN_MIDDLE);
				celdaUser.setHorizontalAlignment(Element.ALIGN_LEFT);
				tabla.addCell(celdaUser);
			}
			documento.add(tabla);
			documento.close();
		}catch (DocumentException e) {
			e.printStackTrace();
		}
		return new ByteArrayInputStream(respuesta.toByteArray());
	}

	@Override
	public ByteArrayInputStream reporteUsuarios(List<Usuario> usuario) {
		Document documento = new Document();
		ByteArrayOutputStream respuesta = new ByteArrayOutputStream();
		try {
			PdfWriter.getInstance(documento, respuesta);
			documento.open();
			Font tipoLetra = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLUE);
			Paragraph parrafo = new Paragraph("Lista de Usuarios", tipoLetra);
			parrafo.setAlignment(Element.ALIGN_CENTER);
			documento.add(parrafo);
			documento.add(Chunk.NEWLINE);
			Font textFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,9);
			
			PdfPTable tabla = new PdfPTable(4);
			Stream.of("id","Nombre","Paterno", "Materno").forEach(headerTitle ->{
				PdfPCell header = new PdfPCell();
				Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD,9);
				header.setBackgroundColor(BaseColor.LIGHT_GRAY);
				header.setHorizontalAlignment(Element.ALIGN_CENTER);
				header.setBorderWidth(1);
				header.setPhrase(new Phrase(headerTitle, headerFont));
				tabla.addCell(header);
			});
			for(Usuario m: usuario) {
				
				PdfPCell celdaNombre = new PdfPCell(new Phrase(Long.toString(m.getIdUsuario()), textFont));
				celdaNombre.setPadding(1);
				celdaNombre.setVerticalAlignment(Element.ALIGN_MIDDLE);
				celdaNombre.setHorizontalAlignment(Element.ALIGN_LEFT);
				tabla.addCell(celdaNombre);
				
				PdfPCell celdaPaterno = new PdfPCell(new Phrase(m.getNombreUsuario(), textFont));
				celdaPaterno.setPadding(1);
				celdaPaterno.setVerticalAlignment(Element.ALIGN_MIDDLE);
				celdaPaterno.setHorizontalAlignment(Element.ALIGN_LEFT);
				tabla.addCell(celdaPaterno);
				
				PdfPCell celdaMaterno = new PdfPCell(new Phrase(m.getPaternoUsuario(), textFont));
				celdaMaterno.setPadding(1);
				celdaMaterno.setVerticalAlignment(Element.ALIGN_MIDDLE);
				celdaMaterno.setHorizontalAlignment(Element.ALIGN_LEFT);
				tabla.addCell(celdaMaterno);
				
				PdfPCell celdaEmail = new PdfPCell(new Phrase(m.getMaternoUsuario(), textFont));
				celdaEmail.setPadding(1);
				celdaEmail.setVerticalAlignment(Element.ALIGN_MIDDLE);
				celdaEmail.setHorizontalAlignment(Element.ALIGN_LEFT);
				tabla.addCell(celdaEmail);
			}
			documento.add(tabla);
			documento.close();
		}catch (DocumentException e) {
			e.printStackTrace();
		}
		return new ByteArrayInputStream(respuesta.toByteArray());
	}

}
