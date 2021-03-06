package br.com.thinkti.android.filechooser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FileArrayAdapter extends ArrayAdapter<Option>
{

    private Context c;
    private int id;
    private List<Option> items;

    public FileArrayAdapter(Context context, int textViewResourceId,
                            List<Option> objects)
    {
        super(context, textViewResourceId, objects);
        c = context;
        id = textViewResourceId;
        items = objects;
    }

    public Option getItem(int i)
    {
        return items.get(i);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = convertView;
        if (v == null)
        {
            LayoutInflater vi = (LayoutInflater) c
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(id, null);
        }
        final Option o = items.get(position);
        if (o != null)
        {
            ImageView im = (ImageView) v.findViewById(R.id.img1);
            TextView t1 = (TextView) v.findViewById(R.id.TextView01);
            TextView t2 = (TextView) v.findViewById(R.id.TextView02);

            if (o.getData().equalsIgnoreCase(getString(R.string.folder)))
            {
                if (o.getName().equalsIgnoreCase("."))
                {
                    im.setImageResource(android.R.drawable.ic_menu_crop);
                }
                else
                {
                    im.setImageResource(R.drawable.folder);
                }
            }
            else if (o.getData().equalsIgnoreCase(getString(R.string.parentDirectory)))
            {
                im.setImageResource(R.drawable.back);
            }
            else
            {
                String name = o.getName().toLowerCase();
                if (name.endsWith(".xls") || name.endsWith(".xlsx"))
                    im.setImageResource(R.drawable.xls);
                else if (name.endsWith(".doc") || name.endsWith(".docx"))
                    im.setImageResource(R.drawable.doc);
                else if (name.endsWith(".ppt") || o.getName().endsWith(".pptx"))
                    im.setImageResource(R.drawable.ppt);
                else if (name.endsWith(".pdf"))
                    im.setImageResource(R.drawable.pdf_list);
                else if (name.endsWith(".apk"))
                    im.setImageResource(R.drawable.and);
                else if (name.endsWith(".txt"))
                    im.setImageResource(R.drawable.txt);
                else if (name.endsWith(".jpg") || name.endsWith(".jpeg"))
                    im.setImageResource(R.drawable.jpg);
                else if (name.endsWith(".png"))
                    im.setImageResource(R.drawable.png);
                else if (name.endsWith(".zip"))
                    im.setImageResource(R.drawable.zip);
                else if (name.endsWith(".rtf"))
                    im.setImageResource(R.drawable.rtf);
                else if (name.endsWith(".gif"))
                    im.setImageResource(R.drawable.gif);
                else
                    im.setImageResource(R.drawable.whitepage);
            }

            if (t1 != null)
                t1.setText(o.getName());
            if (t2 != null)
                t2.setText(o.getData());

        }
        return v;
    }

    /**
     * Return a localized string from the application's package's
     * default string table.
     *
     * @param resId Resource id for the string
     */
    public final String getString(int resId)
    {
        return c.getResources().getString(resId);
    }

    /**
     * Return a localized formatted string from the application's package's
     * default string table, substituting the format arguments as defined in
     * {@link java.util.Formatter} and {@link java.lang.String#format}.
     *
     * @param resId      Resource id for the format string
     * @param formatArgs The format arguments that will be used for substitution.
     */

    public final String getString(int resId, Object... formatArgs)
    {
        return c.getResources().getString(resId, formatArgs);
    }

}
