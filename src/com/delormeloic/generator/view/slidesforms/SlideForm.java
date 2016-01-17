package com.delormeloic.generator.view.slidesforms;

import com.delormeloic.generator.model.slides.Slide;

/**
 * This class represents a slide form.
 * 
 * @author DELORME Loïc
 * @since 1.0.0
 */
public abstract class SlideForm implements IFormable
{
	/**
	 * The slide.
	 */
	protected final Slide slide;

	/**
	 * Create a slide form.
	 * 
	 * @param slide
	 *            The slide.
	 */
	public SlideForm(Slide slide)
	{
		this.slide = slide;
	}

	/**
	 * Get the slide.
	 * 
	 * @return The slide.
	 */
	public Slide getSlide()
	{
		return this.slide;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return this.slide.getName();
	}
}