import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

    public class AppointmentRepository {
        private List<Appointment> appointments;

        public AppointmentRepository() {
            this.appointments = new ArrayList<>();
        }

        public void addAppointment(Appointment appointment) {
            appointments.add(appointment);
        }

        public List<Appointment> getAppointmentsForClient(int clientID) {
            List<Appointment> clientAppointments = new ArrayList<>();
            for (Appointment appointment : appointments) {
                if (appointment.getClientID() == clientID) {
                    clientAppointments.add(appointment);
                }
            }
            return clientAppointments;
        }

        public List<Appointment> getAppointmentsForEmployee(int employeeID) {
            List<Appointment> employeeAppointments = new ArrayList<>();
            for (Appointment appointment : appointments) {
                if (appointment.getEmployeeID() == employeeID) {
                    employeeAppointments.add(appointment);
                }
            }
            return employeeAppointments;
        }

        public List<Appointment> getAppointmentsForService(int serviceID) {
            List<Appointment> serviceAppointments = new ArrayList<>();
            for (Appointment appointment : appointments) {
                if (appointment.getServiceID() == serviceID) {
                    serviceAppointments.add(appointment);
                }
            }
            return serviceAppointments;
        }

        public List<Appointment> getAllAppointments() {
            return new ArrayList<>(appointments); // Return a copy to avoid modifying the internal list
        }

        public void updateAppointment(Appointment updatedAppointment) {
            for (int i = 0; i < appointments.size(); i++) {
                if (appointments.get(i).getClientID() == updatedAppointment.getClientID() &&
                        appointments.get(i).getEmployeeID() == updatedAppointment.getEmployeeID() &&
                        appointments.get(i).getServiceID() == updatedAppointment.getServiceID() &&
                        appointments.get(i).getDateTime().equals(updatedAppointment.getDateTime())) {
                    appointments.set(i, updatedAppointment);
                    return;
                }
            }
        }

        public void deleteAppointment(int clientID, int employeeID, int serviceID, LocalDateTime dateTime) {
            appointments.removeIf(appointment ->
                    appointment.getClientID() == clientID &&
                            appointment.getEmployeeID() == employeeID &&
                            appointment.getServiceID() == serviceID &&
                            appointment.getDateTime().equals(dateTime)
            );
        }
    }


