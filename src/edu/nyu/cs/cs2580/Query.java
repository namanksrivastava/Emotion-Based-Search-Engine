package edu.nyu.cs.cs2580;

import edu.nyu.cs.cs2580.QueryHandler.CgiArguments.EmotionType;

import java.util.Scanner;
import java.util.Vector;

/**
 * Representation of a user query.
 * 
 * In HW1: instructors provide this simple implementation.
 * 
 * In HW2: students must implement {@link QueryPhrase} to handle phrases.
 * 
 * @author congyu
 * @auhtor fdiaz
 */
public class Query {
  public String _query = null;
  public EmotionType _emotionType;
  public int _pagination;
  public Vector<String> _tokens = new Vector<String>();

  public Query(String query, EmotionType emotionType, int pagination) {
    _query = query;
    _emotionType = emotionType;
    _pagination = pagination;
  }

  public void processQuery() {
    if (_query == null) {
      return;
    }
    _query = _query.toLowerCase();
    _query = TextProcessor.regexRemoval(_query);
    Scanner s = new Scanner(_query);
    Stemmer stemmer = new Stemmer();
    while (s.hasNext()) {
      String term = s.next();
      stemmer.add(term.toCharArray(), term.length());
      stemmer.stem();
      _tokens.add(stemmer.toString());
    }
    s.close();
  }
}
