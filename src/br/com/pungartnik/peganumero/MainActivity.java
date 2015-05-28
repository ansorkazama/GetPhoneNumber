package br.com.pungartnik.peganumero;

import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView textView1=(TextView)findViewById(R.id.textView1);  
        
        //Get the instance of TelephonyManager  
        TelephonyManager  tm=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);  
         
        //Calling the methods of TelephonyManager the returns the information  
        String IMEINumber = tm.getDeviceId();  
        String subscriberID = tm.getSubscriberId();  
        String strLineNumber = tm.getLine1Number();
        String SIMSerialNumber = tm.getSimSerialNumber();  
        String networkCountryISO = tm.getNetworkCountryIso();  
        String SIMCountryISO = tm.getSimCountryIso();  
        String softwareVersion = tm.getDeviceSoftwareVersion();  
        String voiceMailNumber = tm.getVoiceMailNumber();  
	String strVoiceAlphaTag = tm.getVoiceMailAlphaTag();
//	String strGroupID = tm.getGroupIdLevel1();

	String strDataState = "";
	int iDataState = tm.getDataState();
	switch( iDataState )
	{
		case TelephonyManager.DATA_DISCONNECTED:
			strDataState = "DATA_DISCONNECTED";
			break;

		case TelephonyManager.DATA_CONNECTING:
			strDataState = "DATA_CONNECTING";
			break;

		case TelephonyManager.DATA_CONNECTED:
			strDataState = "DATA_CONNECTED";
			break;

		case TelephonyManager.DATA_SUSPENDED:
			strDataState = "DATA_SUSPENDED";
			break;

		default:
			strDataState = "DEFAULT: "+iDataState;
			break;
	}

	String strNetType = "";
	int iNetType = tm.getNetworkType();
	switch( iNetType )
	{
		case TelephonyManager.NETWORK_TYPE_1xRTT: //	Current network is 1xRTT
			strNetType = "NETWORK_TYPE_1xRTT";
			break;

		case TelephonyManager.NETWORK_TYPE_CDMA: //	Current network is CDMA: Either IS95A or IS95B
			strNetType = "NETWORK_TYPE_CDMA";
			break;

		case TelephonyManager.NETWORK_TYPE_EDGE: //	Current network is EDGE
			strNetType = "NETWORK_TYPE_EDGE";
			break;

		case TelephonyManager.NETWORK_TYPE_EHRPD: //	Current network is eHRPD
			strNetType = "NETWORK_TYPE_EHRPD";
			break;

		case TelephonyManager.NETWORK_TYPE_EVDO_0: //	Current network is EVDO revision 0
			strNetType = "NETWORK_TYPE_EVDO_0";
			break;

		case TelephonyManager.NETWORK_TYPE_EVDO_A: //	Current network is EVDO revision A
			strNetType = "NETWORK_TYPE_EVDO_A";
			break;

		case TelephonyManager.NETWORK_TYPE_EVDO_B: //	Current network is EVDO revision B
			strNetType = "NETWORK_TYPE_EVDO_";
			break;

		case TelephonyManager.NETWORK_TYPE_GPRS: //	Current network is GPRS
			strNetType = "NETWORK_TYPE_GPRS";
			break;

		case TelephonyManager.NETWORK_TYPE_HSDPA: //	Current network is HSDPA
			strNetType = "NETWORK_TYPE_HSDPA";
			break;

		case TelephonyManager.NETWORK_TYPE_HSPA: //	Current network is HSPA
			strNetType = "NETWORK_TYPE_HSPA";
			break;

		case TelephonyManager.NETWORK_TYPE_HSPAP: //	Current network is HSPA+
			strNetType = "";
			break;

		case TelephonyManager.NETWORK_TYPE_HSUPA: //	Current network is HSUPA
			strNetType = "NETWORK_TYPE_HSUPA";
			break;

		case TelephonyManager.NETWORK_TYPE_IDEN: //	Current network is iDen
			strNetType = "NETWORK_TYPE_IDEN";
			break;

		case TelephonyManager.NETWORK_TYPE_LTE: //	Current network is LTE
			strNetType = "NETWORK_TYPE_LTE";
			break;

		case TelephonyManager.NETWORK_TYPE_UMTS: //	Current network is UMTS
			strNetType = "NETWORK_TYPE_UMTS";
			break;

		case TelephonyManager.NETWORK_TYPE_UNKNOWN: //	Network type is unknown
			strNetType = "NETWORK_TYPE_UNKNOWN";
			break;

		default:
			strNetType = "DEFAULT: "+iNetType;
			break;
	}

	String strSimState = "";
	int iSimState = tm.getSimState();
	switch( iSimState )
	{
		case TelephonyManager.SIM_STATE_UNKNOWN:
			strSimState = "SIM_STATE_UNKNOWN";
			break;

		case TelephonyManager.SIM_STATE_ABSENT:
			strSimState = "SIM_STATE_ABSENT";
			break;

		case TelephonyManager.SIM_STATE_PIN_REQUIRED:
			strSimState = "SIM_STATE_PIN_REQUIRED";
			break;

		case TelephonyManager.SIM_STATE_PUK_REQUIRED:
			strSimState = "SIM_STATE_PUK_REQUIRED";
			break;

		case TelephonyManager.SIM_STATE_NETWORK_LOCKED:
			strSimState = "SIM_STATE_NETWORK_LOCKED";
			break;

		case TelephonyManager.SIM_STATE_READY:
			String strSimoper = tm.getSimOperator(); //(SIM state must be SIM_STATE_READY getSimState())
			String strSimOperName = tm.getSimOperatorName(); //(SIM state must be SIM_STATE_READY getSimState())
			strSimState = "SIM_STATE_READY - "+strSimoper+" - "+strSimOperName;
			break;

/*		case TelephonyManager.SIM_STATE_NOT_READY: // ERROR(/#)
			strSimState = "SIM_STATE_NOT_READY";
			break;

		case TelephonyManager.SIM_STATE_PERM_DISABLED: // ERROR(/#)
			strSimState = "SIM_STATE_PERM_DISABLED";
			break;

		case TelephonyManager.SIM_STATE_CARD_IO_ERROR: // ERROR(/#)
			strSimState = "SIM_STATE_CARD_IO_ERROR";
			break;
*/
		default:
			strSimState = "DEFAULT: "+iSimState;
			break;
	}

        //Get the phone type  
        String strphoneType="";  
        int phoneType = tm.getPhoneType();  
        switch( phoneType )   
        {  
		case (TelephonyManager.PHONE_TYPE_CDMA):  
                	strphoneType="CDMA";  
			break;

		case (TelephonyManager.PHONE_TYPE_GSM):   
			strphoneType="GSM - ";

			String NetCtryIso = tm.getNetworkCountryIso(); //(Nao pode ser CDMA  getPhoneType())
			String NetOper = tm.getNetworkOperator(); //(Nao pode ser CDMA  getPhoneType())
			String NerOperName = tm.getNetworkOperatorName(); //(Nao pode ser CDMA  getPhoneType())

			strphoneType+=NetCtryIso+" - "+NetOper+" - "+NerOperName;
			break;

		case (TelephonyManager.PHONE_TYPE_NONE):  
			strphoneType="NONE";
			break;

		default:
			strphoneType="DEFAULT: "+phoneType;
			break;
         }  
          
        //getting information if phone is in roaming  
        boolean isRoaming=tm.isNetworkRoaming(); 
	boolean isCarrierPrivileges = tm.hasCarrierPrivileges();
	boolean isIccCard = tm.hasIccCard();
//	boolean hasSmsCapable = tm.isSmsCapable();
	boolean hasVoiceCapable = tm.isVoiceCapable();

	String info="Informacoes Fone/Rede:\n"; 
	info+="\n Tipo Telefone: "+strphoneType; 
	info+="\n Numero Telefone: "+strLineNumber;
        info+="\n IMEI Number: "+IMEINumber;  
        info+="\n SubscriberID: "+subscriberID;  
        info+="\n SW Version: "+softwareVersion;
//        info+="\n GroupID: "+strGroupID;
        info+="\n ";
        info+="\n Sim State: "+strSimState;
        info+="\n Sim Serial Number:"+SIMSerialNumber;  
        info+="\n SIM Country ISO:"+SIMCountryISO;  
        info+="\n ";
        info+="\n Data State: "+strDataState;
        info+="\n ";
        info+="\n Tipo de Rede: "+strNetType;
        info+="\n Roaming? :"+isRoaming;  
        info+="\n Network Country ISO:"+networkCountryISO;  
        info+="\n ";
        info+="\n Voice Capable: "+hasVoiceCapable;
        info+="\n Voice Mail Number:"+voiceMailNumber;  
        info+="\n Voice Mail Tag: "+strVoiceAlphaTag;
        info+="\n ";
        info+="\n Carrier Privileges? "+isCarrierPrivileges;
        info+="\n ICC? "+isIccCard;
//        info+="\n SMS? "+hasSmsCapable;

        textView1.setText(info); //displaying the information in the textView 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
