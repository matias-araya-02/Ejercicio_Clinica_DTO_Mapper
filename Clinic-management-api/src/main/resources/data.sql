-- Insertar datos de prueba para pacientes
INSERT INTO pacientes (nombre, apellido, dni, email) VALUES
                                                         ('Juan', 'Pérez', '12345678', 'juan.perez@email.com'),
                                                         ('María', 'González', '87654321', 'maria.gonzalez@email.com'),
                                                         ('Carlos', 'Rodríguez', '11223344', 'carlos.rodriguez@email.com');

-- Insertar datos de prueba para turnos
INSERT INTO turnos (fecha, especialidad, medico, paciente_id) VALUES
                                                                  ('2025-07-30 09:00:00', 'Cardiología', 'Dr. López', 1),
                                                                  ('2025-07-30 10:30:00', 'Dermatología', 'Dra. Martínez', 2),
                                                                  ('2025-07-30 14:00:00', 'Traumatología', 'Dr. García', 1),
                                                                  ('2025-07-31 11:00:00', 'Pediatría', 'Dra. Fernández', 3);