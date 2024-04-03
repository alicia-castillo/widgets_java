package com.talentreef.interviewquestions.takehome.controllers;

import com.talentreef.interviewquestions.takehome.models.Widget;
import com.talentreef.interviewquestions.takehome.services.WidgetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping(value = "/v1/widgets", produces = MediaType.APPLICATION_JSON_VALUE)
public class WidgetController {

  private final WidgetService widgetService;

  public WidgetController(WidgetService widgetService) {
    Assert.notNull(widgetService, "widgetService must not be null");
    this.widgetService = widgetService;
  }

  @GetMapping
  public ResponseEntity<List<Widget>> getAllWidgets() {
    return ResponseEntity.ok(widgetService.getAllWidgets());
  }
  
  @PostMapping("/addWidget")
  public ResponseEntity<Widget> addWidget(@RequestBody Widget widget) {
      return ResponseEntity.ok(widgetService.addWidget(widget));
  }
  
  @GetMapping("/{name}")
  public ResponseEntity<Widget> searchWidgetByName(@PathVariable String name) {
      return ResponseEntity.of(widgetService.getWidgetByName(name));
  }

  @PutMapping("/{name}")
  public Widget updateWidget(@PathVariable String name, @RequestBody Widget widget) {
      return this.widgetService.updateWidgetByName(widget, name);
  }

  @DeleteMapping("/{name}")
  public String deleteWidget(@PathVariable String name){
    JSONObject resp = this.widgetService.deleteWidget(name);
    return resp.toString();
  }

}
