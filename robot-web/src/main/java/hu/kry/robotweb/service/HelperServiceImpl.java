package hu.kry.robotweb.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import hu.kry.robotweb.service.HelperService;


@Service
public class HelperServiceImpl implements HelperService {
	@Override
	public List<String> getEntities() {
		List<String> rv = new ArrayList<String>();
		rv.add("gazda");
		rv.add("idegen");
		rv.add("gonosz");
		return rv;
	}
}
