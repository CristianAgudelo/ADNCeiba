UPDATE asesoria
SET asesor= :asesor,
hora_inicio= :horaInicio,
hora_fin= :horaFin,
fecha_asesoria= :fechaAsesoria,
duracion= :duracion
WHERE id= :id;
