select * from asesoria as a
left join usuario as u on a.asesor = u.id
where u.nombre = :nombre
