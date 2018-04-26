package br.ufmg.coltec.tp.moreaqui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class NovoImovelActivity extends Activity {
    EditText mNameEditText;
    EditText mCityEditText;
    EditText mAddressEditText;
    EditText mTelephoneEditText;
    EditText mRentPriceEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_imovel);

        mNameEditText = findViewById(R.id.property_name_et);
        mCityEditText = findViewById(R.id.property_city_et);
        mAddressEditText = findViewById(R.id.property_address_et);
        mTelephoneEditText = findViewById(R.id.property_tel_et);
        mRentPriceEditText = findViewById(R.id.property_rent_price_et);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_property, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_save_property:
                saveImovel();
                finish();
                return true;
            default:
                return super.onMenuItemSelected(featureId, item);
        }
    }

    private void saveImovel() {
        ImovelDAO imovelDAO = ImovelDAO.getInstance();
        imovelDAO.adicionarImovel(new Imovel(
                mNameEditText.getText().toString(),
                mAddressEditText.getText().toString(),
                mCityEditText.getText().toString(),
                Double.parseDouble(mRentPriceEditText.getText().toString()),
                mTelephoneEditText.getText().toString()
        ));
        Toast.makeText(NovoImovelActivity.this, R.string.toast_added_property, Toast.LENGTH_SHORT).show();
    }
}
