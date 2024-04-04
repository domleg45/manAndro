package edu.mv.interfaceHM

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.mediarouter.app.MediaRouteButton
import androidx.tv.material3.ExperimentalTvMaterial3Api
import com.google.android.gms.cast.framework.CastButtonFactory
import com.google.android.gms.cast.framework.CastContext
import com.google.android.gms.cast.framework.CastSession
import com.google.android.gms.cast.framework.SessionManagerListener
import edu.mv.interfaceHM.NameSpace.SENDER_NAMESPACE
import org.json.JSONObject
import java.util.concurrent.Executors


class MainActivity : FragmentActivity() {

    private var mCastSession: CastSession? = null
    private var posX = 200
    private var posY = 200
    private var maxPosX = 1200
    private var maxPosY = 800
    private var stepX = 5
    private var stepY = 5



    private var mCastContext: CastContext? = null
    private var mMediaRouteButton: MediaRouteButton? = null

    @OptIn(ExperimentalTvMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        mMediaRouteButton = findViewById<View>(R.id.media_route_button) as MediaRouteButton
        CastButtonFactory.setUpMediaRouteButton(applicationContext, mMediaRouteButton!!)
        mCastContext = CastContext.getSharedInstance(this)


        val statusView = findViewById<TextView>(R.id.status_text) as TextView
        val msgCallback = MyMessageReceivedCallback(statusView);
        val mSessionManagerListener = MySessionManagerListener(msgCallback)
        val mSessionManager = mCastContext!!.sessionManager
        mSessionManager.addSessionManagerListener(mSessionManagerListener, CastSession::class.java)

        val upBtn = findViewById<Button>(R.id.up) as Button
        upBtn.setOnClickListener() {
            val castExecutor = Executors.newSingleThreadExecutor()
            val castContext = CastContext.getSharedInstance(this, castExecutor).result
            val castSession = castContext.sessionManager.currentCastSession
            val rootObject= JSONObject()
            if (posY - stepY > 0) {
                posY = posY - stepY;
                rootObject.put("msg",posX.toString().plus(",").plus(posY));
            }

            castSession?.sendMessage(SENDER_NAMESPACE, rootObject.toString());
        }


        val leftBtn = findViewById<Button>(R.id.left) as Button
        leftBtn.setOnClickListener() {
            val castExecutor = Executors.newSingleThreadExecutor()
            val castContext = CastContext.getSharedInstance(this, castExecutor).result
            val castSession = castContext.sessionManager.currentCastSession
            val rootObject= JSONObject()
            if (posX - stepX > 0                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ) {
                posX = posX - stepX;
                rootObject.put("msg",posX.toString().plus(",").plus(posY));
            }

            castSession?.sendMessage(SENDER_NAMESPACE, rootObject.toString());
        }

        val rightBtn = findViewById<Button>(R.id.right) as Button
        rightBtn.setOnClickListener() {
            val castExecutor = Executors.newSingleThreadExecutor()
            val castContext = CastContext.getSharedInstance(this, castExecutor).result
            val castSession = castContext.sessionManager.currentCastSession
            val rootObject= JSONObject()
            if (posX + stepX < maxPosX) {
                posX = posX + stepX;
                rootObject.put("msg",posX.toString().plus(",").plus(posY));
            }

            castSession?.sendMessage(SENDER_NAMESPACE, rootObject.toString());
        }

        val downBtn = findViewById<Button>(R.id.down) as Button
        downBtn.setOnClickListener() {
            val castExecutor = Executors.newSingleThreadExecutor()
            val castContext = CastContext.getSharedInstance(this, castExecutor).result
            val castSession = castContext.sessionManager.currentCastSession
            val rootObject= JSONObject()
            if (posY + stepY < maxPosY) {
                posY = posY + stepY;
                rootObject.put("msg",posX.toString().plus(",").plus(posY));
            }
            castSession?.sendMessage(SENDER_NAMESPACE, rootObject.toString());
        }

    }

}