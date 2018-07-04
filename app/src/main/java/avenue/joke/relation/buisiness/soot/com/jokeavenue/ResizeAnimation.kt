package avenue.joke.relation.buisiness.soot.com.jokeavenue

import android.view.animation.Animation
import android.view.animation.Transformation
import android.view.View

class ResizeAnimation(var view: View, var addHeight: Int,var startHeight: Int):
        Animation() {

    override fun applyTransformation(interpolatedTime: Float, t: Transformation?) {
        val newHeight = startHeight + addHeight * interpolatedTime
        view.layoutParams.height = newHeight.toInt()
        view.requestLayout()
    }

    override fun willChangeBounds(): Boolean {
        return true
    }
}