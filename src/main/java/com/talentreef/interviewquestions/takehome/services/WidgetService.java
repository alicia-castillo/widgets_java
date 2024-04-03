package com.talentreef.interviewquestions.takehome.services;

import com.talentreef.interviewquestions.takehome.models.Widget;
import com.talentreef.interviewquestions.takehome.respositories.WidgetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;
import org.json.JSONObject;

@Slf4j
@Service
public class WidgetService {

  private final WidgetRepository widgetRepository;

  @Autowired
  private WidgetService(WidgetRepository widgetRepository) {
    Assert.notNull(widgetRepository, "widgetRepository must not be null");
    this.widgetRepository = widgetRepository;
  }

  public List<Widget> getAllWidgets() {
    return widgetRepository.findAll();
  }
  
  public Widget addWidget(Widget widget){
    List<Widget> widgets = widgetRepository.findAll();
    for (Widget wgt: widgets){
    if(wgt.getName().equals(widget.getName())){
        return null;
    }
    }
    return widgetRepository.save(widget);
  }
  
  public Optional<Widget> getWidgetByName(String name){
    try{
      Optional<Widget> wid = widgetRepository.findById(name);
      return wid;
    }catch(Exception e){
      return null;
    }
  }

  public Widget updateWidgetByName(Widget req, String name){
    Widget widget = widgetRepository.findById(name).get();
    widget.setDescription(req.getDescription());
    widget.setPrice(req.getPrice());

    return widget;
  }

  public JSONObject deleteWidget(String name){
    JSONObject resp = new JSONObject();
    try {
      resp.put("ok", true);
      resp.put("widget", widgetRepository.deleteById(name));
      System.out.println("this is deleted resp ");
      System.out.println(resp);
    return resp;
    } catch(Exception e){
      resp.put("ok", false);
      resp.put("message", e);
      return resp;
    }
  }

}
