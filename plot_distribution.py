import numpy as np
import matplotlib.pyplot as plt
ticks = range(17)
b = [1.29E-9, 5.12E-8, 9.56E-7, 0.000011, 0.000091, 0.000552, 0.002579,
	0.009457, 0.027584, 0.064363, 0.057086, 0.024218, 0.008072, 0.002069,
	0.000394, 0.000052, 0.000004,  1.72E-7]
plt.xticks(ticks)
plt.plot(b)
plt.show()
