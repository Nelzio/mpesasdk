package mz.co.moovi.mpesaapi

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import mz.co.moovi.mpesalibui.MpesaSdk

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ///Initialize with application once
        MpesaSdk.init(
                apiKey = "your_api_key_here",
                publicKey = """your_public_key_here""",
                endpointUrl = "your_endpoint_url_here",
                serviceProviderName = "your_service_name_here",
                serviceProviderCode = "your_service_provide_code_here",
                serviceProviderLogoUrl = "https://www.vodacom.co.za/vodacom/home/images/header/vodacom_icon.77b545abd1d7a4e0808b5a2255438f64.png")

        MpesaSdk.pay(activity = this, requestCode = 1, amount = "1", transactionReference = "keep_changing_this_as_you_test")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> {
                when (resultCode) {
                    Activity.RESULT_OK -> {
                        //Handle success send info to your server
                    }
                    Activity.RESULT_CANCELED -> {
                        //Handle failure tell something to the user
                    }
                }
            }
        }
    }

}
