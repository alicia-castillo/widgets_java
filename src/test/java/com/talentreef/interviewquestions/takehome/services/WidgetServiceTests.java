package com.talentreef.interviewquestions.takehome.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.talentreef.interviewquestions.takehome.models.Widget;
import com.talentreef.interviewquestions.takehome.respositories.WidgetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class WidgetServiceTests {

  @Mock
  private WidgetRepository widgetRepository;

  @InjectMocks
  private WidgetService widgetService;

  @Test
  public void when_getAllWidgets_expect_findAllResult() throws Exception {
    //Widget widget = Widget.builder().name("Widgette Nielson").build();
    Widget widget = new Widget();
    widget.setName("Widgette Nielson");
    List<Widget> response = List.of(widget);
    when(widgetRepository.findAll()).thenReturn(response);

    List<Widget> result = widgetService.getAllWidgets();

    assertThat(result).isEqualTo(response);
  }
  
  @Test
  public void when_addWidget_expect_widget() throws Exception {
      Widget widget = new Widget();
      widget.setName("widgette Nielson");
      widget.setDescription("this is a description");
      widget.setPrice(23.334);
      Widget response = widget;
      when(widgetRepository.save(widget)).thenReturn(response);
      Widget result = widgetService.addWidget(widget);
      
      assertThat(result).isEqualTo(response);
  }

}
