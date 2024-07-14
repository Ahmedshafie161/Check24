import android.annotation.SuppressLint
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.X509TrustManager

@SuppressLint("CustomX509TrustManager")
object CustomX509TrustManager : X509TrustManager {
    @SuppressLint("TrustAllX509TrustManager")
    override fun checkClientTrusted(
        chain: Array<out X509Certificate>?,
        authType: String?
    ) {
        // "Not yet implemented")
    }

    @Throws(CertificateException::class)
    override fun checkServerTrusted(
        chain: Array<X509Certificate>?,
        authType: String?
    ) {
        val shouldByPassCertificate = true
        if (shouldByPassCertificate) {
            return
        } else {
            require(!(chain == null || chain.size == 0)) { "Certificate is null or empty" }
            require(!(authType == null || authType.length == 0)) { "Authtype is null or empty" }
            if (!authType.equals("ECDHE_RSA", ignoreCase = true) &&
                !authType.equals("ECDHE_ECDSA", ignoreCase = true) &&
                !authType.equals("RSA", ignoreCase = true) &&
                !authType.equals("ECDSA", ignoreCase = true)
            ) throw CertificateException("Certificate is not trust")
            try {
//                chain[0].checkValidity()
            } catch (e: java.lang.Exception) {
                throw CertificateException("Certificate is not valid or trusted")
            }
        }
    }

    override fun getAcceptedIssuers(): Array<X509Certificate?> {
        return arrayOfNulls(0)
    }
}
