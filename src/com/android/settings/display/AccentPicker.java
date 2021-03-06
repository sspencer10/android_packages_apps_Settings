/*
 * Copyright (C) 2018 The Dirty Unicorns Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.display;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.om.IOverlayManager;
import android.os.Bundle;
import android.os.ServiceManager;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.android.internal.logging.nano.MetricsProto;
import com.android.internal.statusbar.ThemeAccentUtils;

import com.android.settings.R;
import com.android.settings.core.instrumentation.InstrumentedDialogFragment;

public class AccentPicker extends InstrumentedDialogFragment implements OnClickListener {

    private static final String TAG_ACCENT_PICKER = "accent_picker";

    private View mView;

    private IOverlayManager mOverlayManager;
    private int mCurrentUserId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOverlayManager = IOverlayManager.Stub.asInterface(
                ServiceManager.getService(Context.OVERLAY_SERVICE));
        mCurrentUserId = ActivityManager.getCurrentUser();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mView = LayoutInflater.from(getActivity()).inflate(R.layout.accent_picker, null);

        if (mView != null) {
            initView();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(mView)
                .setNegativeButton(R.string.cancel, this)
                .setNeutralButton(R.string.theme_accent_picker_default, this)
                .setCancelable(false);

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        return dialog;
    }

    private void initView() {

        Button redAccent = mView.findViewById(R.id.redAccent);
        setAccent("1", redAccent);

        Button pinkAccent = mView.findViewById(R.id.pinkAccent);
        setAccent("2", pinkAccent);

        Button purpleAccent = mView.findViewById(R.id.purpleAccent);
        setAccent("3", purpleAccent);

        Button deeppurpleAccent = mView.findViewById(R.id.deeppurpleAccent);
        setAccent("4", deeppurpleAccent);

        Button indigoAccent = mView.findViewById(R.id.indigoAccent);
        setAccent("5", indigoAccent);

        Button blueAccent = mView.findViewById(R.id.blueAccent);
        setAccent("6", blueAccent);

        Button lightblueAccent = mView.findViewById(R.id.lightblueAccent);
        setAccent("7", lightblueAccent);

        Button cyanAccent = mView.findViewById(R.id.cyanAccent);
        setAccent("8", cyanAccent);

        Button tealAccent = mView.findViewById(R.id.tealAccent);
        setAccent("9", tealAccent);

        Button greenAccent = mView.findViewById(R.id.greenAccent);
        setAccent("10", greenAccent);

        Button lightgreenAccent = mView.findViewById(R.id.lightgreenAccent);
        setAccent("11", lightgreenAccent);

        Button limeAccent = mView.findViewById(R.id.limeAccent);
        setAccent("12", limeAccent);

        Button yellowAccent = mView.findViewById(R.id.yellowAccent);
        setAccent("13", yellowAccent);

        Button amberAccent = mView.findViewById(R.id.amberAccent);
        setAccent("14", amberAccent);

        Button orangeAccent = mView.findViewById(R.id.orangeAccent);
        setAccent("15", orangeAccent);

        Button deeporangeAccent = mView.findViewById(R.id.deeporangeAccent);
        setAccent("16", deeporangeAccent);

        Button brownAccent = mView.findViewById(R.id.brownAccent);
        setAccent("17", brownAccent);

        Button greyAccent = mView.findViewById(R.id.greyAccent);
        setAccent("18", greyAccent);

        Button bluegreyAccent = mView.findViewById(R.id.bluegreyAccent);
        setAccent("19", bluegreyAccent);

        Button blackAccent = mView.findViewById(R.id.blackAccent);
        // Change the accent picker button depending on whether or not a dark theme is applied
        blackAccent.setBackgroundColor(getResources().getColor(
                (ThemeAccentUtils.isUsingDarkTheme(mOverlayManager, mCurrentUserId) || ThemeAccentUtils.isUsingBlackTheme(mOverlayManager, mCurrentUserId) || ThemeAccentUtils.isUsingShishuNightsTheme(mOverlayManager, mCurrentUserId) || ThemeAccentUtils.isUsingChocolateTheme(mOverlayManager, mCurrentUserId)) ? R.color.accent_picker_white_accent : R.color.accent_picker_dark_accent));
        blackAccent.setBackgroundTintList(getResources().getColorStateList(
                (ThemeAccentUtils.isUsingDarkTheme(mOverlayManager, mCurrentUserId) || ThemeAccentUtils.isUsingBlackTheme(mOverlayManager, mCurrentUserId) || ThemeAccentUtils.isUsingShishuNightsTheme(mOverlayManager, mCurrentUserId) || ThemeAccentUtils.isUsingChocolateTheme(mOverlayManager, mCurrentUserId)) ? R.color.accent_picker_white_accent : R.color.accent_picker_dark_accent));
        setAccent("20", blackAccent);

        //"21" reserved for whiteAccent

        Button userAccentOne = mView.findViewById(R.id.userAccentOne);
        setAccent("22", userAccentOne);

        Button userAccentTwo = mView.findViewById(R.id.userAccentTwo);
        setAccent("23", userAccentTwo);

        Button userAccentThree = mView.findViewById(R.id.userAccentThree);
        setAccent("24", userAccentThree);

        Button userAccentFour = mView.findViewById(R.id.userAccentFour);
        setAccent("25", userAccentFour);

        Button userAccentFive = mView.findViewById(R.id.userAccentFive);
        setAccent("26", userAccentFive);

        Button userAccentSix = mView.findViewById(R.id.userAccentSix);
        setAccent("27", userAccentSix);

        Button userAccentSeven = mView.findViewById(R.id.userAccentSeven);
        setAccent("28", userAccentSeven);

        Button candyredAccent = mView.findViewById(R.id.candyredAccent);
        setAccent("29", candyredAccent);

        Button paleredAccent = mView.findViewById(R.id.paleredAccent);
        setAccent("30", paleredAccent);

        Button extendedgreenAccent = mView.findViewById(R.id.extendedgreenAccent);
        setAccent("31", extendedgreenAccent);

        Button paleblueAccent = mView.findViewById(R.id.paleblueAccent);
        setAccent("32", paleblueAccent);

        Button jadegreenAccent = mView.findViewById(R.id.jadegreenAccent);
        setAccent("33", jadegreenAccent);

        Button holillusionAccent = mView.findViewById(R.id.holillusionAccent);
        setAccent("34", holillusionAccent);

        Button stockAccent = mView.findViewById(R.id.stockAccent);
        setAccent("35", stockAccent);

        Button seasidemintAccent = mView.findViewById(R.id.seasidemintAccent);
        setAccent("36", seasidemintAccent);

        Button movemintAccent = mView.findViewById(R.id.movemintAccent);
        setAccent("37", movemintAccent);

        Button diffdaygreenAccent = mView.findViewById(R.id.diffdaygreenAccent);
        setAccent("38", diffdaygreenAccent);

        Button obfusbleuAccent = mView.findViewById(R.id.obfusbleuAccent);
        setAccent("39", obfusbleuAccent);

        Button frenchbleuAccent = mView.findViewById(R.id.frenchbleuAccent);
        setAccent("40", frenchbleuAccent);

        Button coldbleuAccent = mView.findViewById(R.id.coldbleuAccent);
        setAccent("41", coldbleuAccent);

        Button heirloombleuAccent = mView.findViewById(R.id.heirloombleuAccent);
        setAccent("42", heirloombleuAccent);

        Button notimppurpleAccent = mView.findViewById(R.id.notimppurpleAccent);
        setAccent("43", notimppurpleAccent);

        Button footprintpurpleAccent = mView.findViewById(R.id.footprintpurpleAccent);
        setAccent("44", footprintpurpleAccent);

        Button duskpurpleAccent = mView.findViewById(R.id.duskpurpleAccent);
        setAccent("45", duskpurpleAccent);

        Button illusionspurpleAccent = mView.findViewById(R.id.illusionspurpleAccent);
        setAccent("46", illusionspurpleAccent);

        Button dreamypurpleAccent = mView.findViewById(R.id.dreamypurpleAccent);
        setAccent("47", dreamypurpleAccent);

        Button spookedpurpleAccent = mView.findViewById(R.id.spookedpurpleAccent);
        setAccent("48", spookedpurpleAccent);

        Button trufilpinkAccent = mView.findViewById(R.id.trufilpinkAccent);
        setAccent("49", trufilpinkAccent);

        Button bubblegumpinkAccent = mView.findViewById(R.id.bubblegumpinkAccent);
        setAccent("50", bubblegumpinkAccent);

        Button hazedpinkAccent = mView.findViewById(R.id.hazedpinkAccent);
        setAccent("51", hazedpinkAccent);

        Button burningredAccent = mView.findViewById(R.id.burningredAccent);
        setAccent("52", burningredAccent);

        Button newhouseorangeAccent = mView.findViewById(R.id.newhouseorangeAccent);
        setAccent("53", newhouseorangeAccent);

        Button warmthorangeAccent = mView.findViewById(R.id.warmthorangeAccent);
        setAccent("54", warmthorangeAccent);

        Button maniaamberAccent = mView.findViewById(R.id.maniaamberAccent);
        setAccent("54", maniaamberAccent);

        Button coldyellowAccent = mView.findViewById(R.id.coldyellowAccent);
        setAccent("55", coldyellowAccent);

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        ContentResolver resolver = getActivity().getContentResolver();

        if (which == AlertDialog.BUTTON_NEGATIVE) {
            dismiss();
        }
        if (which == AlertDialog.BUTTON_NEUTRAL) {
            Settings.System.putIntForUser(resolver,
                    Settings.System.ACCENT_PICKER, 0, mCurrentUserId);
            dismiss();
        }
    }

    public static void show(Fragment parent) {
        if (!parent.isAdded()) return;

        final AccentPicker dialog = new AccentPicker();
        dialog.setTargetFragment(parent, 0);
        dialog.show(parent.getFragmentManager(), TAG_ACCENT_PICKER);
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.PIXELDUST;
    }

    private void setAccent(final String accent, final Button buttonAccent) {
        final ContentResolver resolver = getActivity().getContentResolver();
        if (buttonAccent != null) {
            buttonAccent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Settings.System.putIntForUser(resolver,
                            Settings.System.ACCENT_PICKER, Integer.parseInt(accent), mCurrentUserId);
                    dismiss();
                }
            });
        }
    }
}
