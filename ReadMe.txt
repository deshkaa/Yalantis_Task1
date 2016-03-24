There were several UI mistakes in the given screeshot, in particular:
 - rows have different padding 
 - a line-view between two of them is of a wrong color.

Solution to this issues is
 - to use the same padding - paddingTop and paddingBottom for views and textViews which play similar roles in UI
 - to apply the same color to the views which play similar roles in UI.

The smartest way to do all that is to create and apply styles special for each grop of the resembling views. 