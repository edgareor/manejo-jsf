package log4j2;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DebuggerListener implements PhaseListener{ // Debe implementar la interfaz PhaseListener

	private static final long serialVersionUID = 1L;
	
	Logger log = LogManager.getRootLogger();

	@Override
	public void afterPhase(PhaseEvent arg0) {
		if (log.isInfoEnabled()) {
			log.info("Antes de la fase: " + arg0.getPhaseId().toString());	// Obtener fase actual.
		}
	}

	@Override
	public void beforePhase(PhaseEvent arg0) {
		if (log.isInfoEnabled()) {
			log.info("Despues de la fase: " + arg0.getPhaseId().toString());	// Obtener fase actual.
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
