UPDATE asesoria
SET asesor= :asesor,
hora_inicio= :hora_inicio,
hora_fin= :hora_fin,
fecha_asesoria= :fecha_asesoria,
duracion= :duracion
WHERE id= :id;
