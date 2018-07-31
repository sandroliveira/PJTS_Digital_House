package ag_al.com.entregvelaula33;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class FragmentAdapterViewPager extends FragmentStatePagerAdapter {
    List<Fragment> lista;

    public FragmentAdapterViewPager (FragmentManager fm, List<Fragment> lista){
        super(fm);
        this.lista = lista;
    }

    @Override
    public Fragment getItem(int position) {
        return lista.get(position);
    }

    @Override
    public int getCount() {
        return lista.size();
    }
}
