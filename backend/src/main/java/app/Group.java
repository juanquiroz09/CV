package app;

import java.util.ArrayList;
import java.util.List;

public class Group {

  List<Experiencia> exps = new ArrayList<Experiencia>();
  List<Experiencia> conos = new ArrayList<Experiencia>();
  List<Experiencia> refes = new ArrayList<Experiencia>();

  public void addExperiencia(Experiencia _exp) {
    exps.add(_exp);
  }

  public List<Experiencia> getGroup() {
    return exps;
  }

  public int getCount() {
    return exps.size();
  }

 /* public void deleteExperiencia(Experiencia _exp) {
    exps.remove(_exp);
  }
*/

  public void addConocimiento(Experiencia _cono) {
    conos.add(_cono);
  }

  public List<Experiencia> getGroup_two() {
    return conos;
  }

  public int getCount_two() {
    return conos.size();
  }

  public void addReferencia(Experiencia _refe) {
    conos.add(_refe);
  }

  public List<Experiencia> getGroup_three() {
    return refes;
  }

  public int getCount_three() {
    return refes.size();
  }
}

