// This file is automatically generated by the Open Roberta Lab.
#define _ARDUINO_STL_NOT_NEEDED
#include "SenseBoxMCU.h"
#undef max
#undef min
#include <NEPODefs.h>
#include <Adafruit_GFX.h>
#include <Adafruit_SSD1306.h>
#include <Plot.h>

unsigned long _time = millis();


BMX055 _bmx055_B;
int _getValueFromBmx(int axis, int mode) {
    int _x_axis;
    int _y_axis;
    int _z_axis;
    switch (mode) {
        case 1:
            _bmx055_B.getRotation(&_x_axis, &_y_axis, &_z_axis);
            break;
        case 2:
            _bmx055_B.getMagnet(&_x_axis, &_y_axis, &_z_axis);
            break;
    }
    switch (axis) {
        case 1:
            return _x_axis;
        case 2:
            return _y_axis;
        case 3:
            return _z_axis;
    }
}

#define OLED_RESET 4
Adafruit_SSD1306 _display_L(OLED_RESET);
Plot _plot_L(&_display_L);

void setup()
{
    _bmx055_B.beginAcc(0x03);
    senseBoxIO.powerI2C(true);
    delay(2000);
    _display_L.begin(SSD1306_SWITCHCAPVCC, 0x3D);
    _display_L.display();
    delay(100);
    _display_L.clearDisplay();
    _plot_L.setTitle("P");
    _plot_L.setXLabel("X");
    _plot_L.setYLabel("Y");
    _plot_L.setXRange(0, 100);
    _plot_L.setYRange(0, 50);
    _plot_L.setXTick(10);
    _plot_L.setYTick(10);
    _plot_L.setXPrecision(0);
    _plot_L.setYPrecision(0);
    _plot_L.clear();
}

void loop()
{
    for (int ___i = 1; ___i < 100; ___i += 1) {
        _plot_L.addDataPoint(___i, _bmx055_B.getAccelerationX());
        
        delay(100);
        delay(1);
    }
    _plot_L.clear();
    _plot_L.drawPlot();
    
}
