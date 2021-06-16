package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		return randomQuote(repository.findAll());
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		return randomQuote(repository.findByActor(actor));
	}

	private Quote randomQuote(List<Quote> quotes){
		return quotes.get(new Random().nextInt(quotes.size()));
	}
}
