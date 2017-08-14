/**
 * Wi-Fi в метро (pw.thedrhax.mosmetro, Moscow Wi-Fi autologin)
 * Copyright © 2015 Dmitry Karikh <the.dr.hax@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pw.thedrhax.captcharecognition;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;

import pw.thedrhax.util.Util;

public class RecognitionService extends IntentService {
    private CaptchaRecognition cr = null;

    public RecognitionService() {
        super("CaptchaRecognition");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent == null) return;

        if (cr == null) {
            cr = new CaptchaRecognition(RecognitionService.this);
        }

        Bitmap bitmap = Util.base64ToBitmap(intent.getStringExtra("bitmap_base64"));
        String code = cr.recognize(bitmap);

        sendBroadcast(new Intent("pw.thedrhax.captcharecognition.RESULT").putExtra("code", code));
    }

    @Override
    public void onDestroy() {
        cr.close();
    }
}
